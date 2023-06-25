package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName.isEmpty()) {
            return new String[0];
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String[] wordsStartsWithW = new String[0];

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[\\s.,]+");

                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Z]", "");

                    if (!cleanedWord.isEmpty() && cleanedWord.toLowerCase().startsWith("w")) {
                        wordsStartsWithW = Arrays.copyOf(wordsStartsWithW, wordsStartsWithW.length + 1);
                        wordsStartsWithW[wordsStartsWithW.length - 1] = cleanedWord.toLowerCase();
                    }
                }
            }

            Arrays.sort(wordsStartsWithW);
            return wordsStartsWithW;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }
}
