package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);

        if (!checkIfExistAndTryToCreateNewFile(file)) {
            return new String[] {};
        }

        String content = getStringFromFile(file);

        String[] words = content.split("\\W+");

        String filteredWords = filteredWordsByFirstLetter(words, 'w');

        if (filteredWords.isEmpty()) {
            return new String[] {};
        }

        String[] sortedFilteredWords = filteredWords.split(System.lineSeparator());

        Arrays.sort(sortedFilteredWords);

        return sortedFilteredWords;
    }

    private boolean checkIfExistAndTryToCreateNewFile(File file) {
        boolean isCreated = true;

        if (!file.exists()) {
            try {
                isCreated = file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Could not create file", e);
            }
        }

        return isCreated;
    }

    private String getStringFromFile(File file) {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();

            while (line != null) {
                contentBuilder
                        .append(line)
                        .append(" ");

                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Could not read file", e);
        }

        return contentBuilder.toString();
    }

    private String filteredWordsByFirstLetter(String[] words, char letter) {
        StringBuilder filteredWordsBuilder = new StringBuilder();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            char firstChar = word.charAt(0);

            if (firstChar == letter || firstChar == Character.toUpperCase(letter)) {
                filteredWordsBuilder
                        .append(word.toLowerCase())
                        .append(System.lineSeparator());
            }
        }

        return filteredWordsBuilder.toString();
    }
}
