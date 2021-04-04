package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {

    private static final char FILTER_CHARACTER = 'w';
    private static final int ASCII_CODE_FOR_PUNCTUATION_MARKS = 63;

    public String[] readFromFile(String fileName) {
        if (fileName == null) {
            return new String[0];
        }
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }

        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                fileContent.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] allWords = fileContent.toString().split("\\s+");
        ArrayList<String> filteredWords = new ArrayList<>(allWords.length);
        for (String word : allWords) {
            word = word.toLowerCase();
            if (word.charAt(0) != FILTER_CHARACTER) {
                continue;
            }
            char lastCharacter = word.charAt(word.length() - 1);
            if (!Character.isLetter(lastCharacter)) {
                word = word.substring(0, word.length() - 1);
            }
            filteredWords.add(word);
        }
        String[] sortedFilteredArray = filteredWords.toArray(new String[0]);

        Arrays.sort(sortedFilteredArray);

        return sortedFilteredArray;
    }
}