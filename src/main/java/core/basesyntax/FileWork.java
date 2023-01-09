package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHAR_START = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String stringFile;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            if (value != null) {
                while (value != null) {
                    stringBuilder.append(value).append(System.lineSeparator());
                    value = reader.readLine();
                }
            } else {
                return new String[0];
            }
            stringFile = stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] withoutPunctuation = stringFile.split("\\W+");
        StringBuilder stringWithW = new StringBuilder();
        for (String word: withoutPunctuation) {
            if (word.startsWith(CHAR_START)) {
                stringWithW.append(word).append(" ");
            }
        }
        if (stringWithW.length() < 1) {
            return new String[0];
        }
        String[] wordStartW = stringWithW.toString().split(" ");
        Arrays.sort(wordStartW);
        return wordStartW;
    }
}
