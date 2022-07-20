package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String words;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String value;
            while ((value = reader.readLine()) != null) {
                builder.append(value).append(System.lineSeparator());
            }
            words = builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (words.length() != 0) {
            String[] wordsArr = words.toLowerCase().split("\\W+");
            StringBuilder builderWords = new StringBuilder();
            for (String word : wordsArr) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    builderWords.append(word).append(" ");
                }
            }
            if (builderWords.length() != 0) {
                String[] result = builderWords.toString().split(" ");
                Arrays.sort(result);
                return result;
            }
        }
        return new String[] {};
    }
}
