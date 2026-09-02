package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        char targetLetter = 'w';
        StringBuilder wordsToSort = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-z]", "");
                    if (word.startsWith(String.valueOf(targetLetter))) {
                        wordsToSort.append(word).append(" ");
                    }
                }
            }

            if (wordsToSort.length() == 0) {
                return new String[0];
            }

            String[] filteredWords = wordsToSort.toString().trim().split("\\s+");
            Arrays.sort(filteredWords);
            return filteredWords;

        } catch (IOException e) {
            throw new RuntimeException(fileName, e);
        }
    }
}
