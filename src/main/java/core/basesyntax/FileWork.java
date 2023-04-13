package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        String[] lines = readData(fileName).split("\\W+");
        int counterLetter = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith(SPECIFIED_CHARACTER)) {
                counterLetter++;
            }
        }
        String[] wordStartsInLetter = new String[counterLetter];
        int count = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith(SPECIFIED_CHARACTER)) {
                wordStartsInLetter[count++] = lines[i];
            }
        }
        Arrays.sort(wordStartsInLetter);
        return wordStartsInLetter;
    }

    public String readData(String fromFile) {
        File file = new File(fromFile);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result = reader.readLine();
            while (result != null) {
                builder.append(result).append(" ");
                result = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString().toLowerCase();
    }
}

