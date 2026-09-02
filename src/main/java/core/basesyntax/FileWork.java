package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringLine = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] arrayWords = value.toLowerCase().split(" ");
                for (String word : arrayWords) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringLine.append(word).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + fileName);
        }
        String clearValue = stringLine.toString().replaceAll("\\pP", "");
        String[] wordsWithW = clearValue.split(" ");
        Arrays.sort(wordsWithW);
        return stringLine.length() != 0 ? wordsWithW : new String[]{};
    }
}
