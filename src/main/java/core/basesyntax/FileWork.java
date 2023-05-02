package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder strBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                for (String word : value.toLowerCase().split(" ")) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        strBuilder.append(word.toLowerCase()
                                .replaceAll("[!?,.:;]", ""))
                                .append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] wordsResult = strBuilder.toString().split(" ");
        Arrays.sort(wordsResult);
        if (wordsResult.length == 0) {
            return new String[] {};
        }
        return wordsResult;
    }
}
