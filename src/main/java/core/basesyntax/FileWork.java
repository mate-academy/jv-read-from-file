package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String pattern = "\\W+\\s|\\s|\\W$";
    private static final char FIRST_LETTER = 'w';
    private static final String SPLIT_STRING = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                line = line.toLowerCase();
                String[] splitLine = line.split(pattern);
                for (String word : splitLine) {
                    if (word.toCharArray()[0] == FIRST_LETTER) {
                        builder.append(word).append(SPLIT_STRING);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("file was not found");
        }

        String values = builder.toString();
        if (builder.length() == 0) {
            return new String[0];
        }

        String[] wordList = builder.toString().split(SPLIT_STRING);
        Arrays.sort(wordList);
        return wordList;
    }
}
