package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder lines = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                lines.append(value.toLowerCase()).append(System.lineSeparator()).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String[] wordsFromLines = lines.toString().split(" ");
        StringBuilder words = new StringBuilder();

        for (String word : wordsFromLines) {
            if (word.startsWith("w")) {
                words.append(word.replaceAll("[^a-z]","")).append(" ");
            }
        }
        String[] wordsWithW = words.toString().split(" ");
        Arrays.sort(wordsWithW);

        return !words.toString().equals("") ? wordsWithW : new String[0];
    }
}
