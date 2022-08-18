package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private static final String WHITESPACE_REGEX = "\\s";
    private static final String SPECIFIED_LETTER_UPPER_CASE = "W";
    private static final String SPECIFIED_LETTER_LOWER_CASE = "w";

    public String[] readFromFile(String fileName) {
        String[] wordsStartingWithW;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String string = bufferedReader.readLine();
            while (string != null) {
                stringBuilder.append(string).append(" ");
                string = bufferedReader.readLine();
            }
            String[] wordsFromFile = stringBuilder.toString()
                    .replaceAll(PUNCTUATION_REGEX, "")
                    .split(WHITESPACE_REGEX);
            wordsStartingWithW = extractWordsStartingWithW(wordsFromFile);
            sortArray(wordsStartingWithW);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Specified file not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read a file", e);
        }
        return wordsStartingWithW;
    }

    private String[] extractWordsStartingWithW(String[] words) {
        int quantity = countWordsStartingWithW(words);
        String[] wordsStartingWithW = new String[quantity];
        insertWWordsToArray(wordsStartingWithW, words);
        return wordsStartingWithW;
    }

    private int countWordsStartingWithW(String[] words) {
        int counter = 0;
        for (String word : words) {
            if (checkWordStartWithW(word)) {
                counter++;
            }
        }
        return counter;
    }

    private void insertWWordsToArray(String[] targetArray, String[] inputArray) {
        int currentIndex = 0;
        for (String word: inputArray) {
            if (checkWordStartWithW(word)) {
                targetArray[currentIndex] = word.toLowerCase();
                currentIndex++;
            }
        }
    }

    private void sortArray(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].compareToIgnoreCase(words[j]) < 0) {
                    String temporary = words[i];
                    words[i] = words[j];
                    words[j] = temporary;
                }
            }
        }
    }

    private boolean checkWordStartWithW(String word) {
        return word.startsWith(SPECIFIED_LETTER_UPPER_CASE)
                || word.startsWith(SPECIFIED_LETTER_LOWER_CASE);
    }
}
