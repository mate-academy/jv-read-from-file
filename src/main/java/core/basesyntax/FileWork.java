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
        StringBuilder allWords;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            allWords = new StringBuilder();
            String words = reader.readLine();
            while (words != null) {
                allWords.append(words).append(System.lineSeparator());
                words = reader.readLine();
            }
            allWords.deleteCharAt(allWords.length() - 1).deleteCharAt(allWords.length() - 1);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        String[] arrayToFilter = allWords.toString().split("\\s+");
        ArrayList<String> filteredArray = new ArrayList<>();
        for (String word : arrayToFilter) {
            if (word.charAt(0) == FILTER_CHARACTER || word.charAt(0) == Character.toUpperCase(FILTER_CHARACTER)) {
                char[] array = word.toCharArray();
                if ((int) array[array.length -1] <= ASCII_CODE_FOR_PUNCTUATION_MARKS) {
                    StringBuilder correctWord = new StringBuilder();
                    for (int i = 0; i < array.length - 1; i++) {
                        correctWord.append(array[i]);
                    }
                    word = correctWord.toString();
                }
                filteredArray.add(word.toLowerCase());
            }
        }
        String[] sortedFilteredArray = filteredArray.toArray(new String[0]);

        Arrays.sort(sortedFilteredArray);

        return sortedFilteredArray;
    }
}