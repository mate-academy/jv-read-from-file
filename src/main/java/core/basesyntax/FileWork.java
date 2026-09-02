package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String text = readFileContent(fileName);
        if (text.isEmpty()) {
            return new String[0];
        }

        String[] words = splitTextIntoWords(text);
        String[] filteredWords = filterWordsStartingWith(words, SPECIFIED_CHARACTER);

        if (filteredWords.length == 0) {
            return new String[0];
        }

        Arrays.sort(filteredWords);
        return filteredWords;
    }

    private String readFileContent(String fileName) {
        StringBuilder allText = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                allText.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return allText.toString().trim();
    }

    private String[] splitTextIntoWords(String text) {
        return text.toLowerCase().split("\\W+");
    }

    private String[] filterWordsStartingWith(String[] words, String character) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(character)) {
                count++;
            }
        }

        String[] filteredWords = new String[count];
        int index = 0;
        for (String word : words) {
            if (word.startsWith(character)) {
                filteredWords[index++] = word;
            }
        }

        return filteredWords;
    }
}
