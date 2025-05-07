package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String PUNCTUATION = "\\W+";
    private static final char FIRST_LETTER_OF_WORDS = 'w';

    public String[] readFromFile(String fileName) {
        String lowerCaseStringFromFile = convertFileToString(fileName).toLowerCase();
        if (lowerCaseStringFromFile.isEmpty()) {
            return new String[0];
        }
        String[] arrayFromFile = lowerCaseStringFromFile.split(PUNCTUATION);

        return getNaturallySortedArray(
                extractInitialLetterWords(arrayFromFile, FIRST_LETTER_OF_WORDS));
    }

    private static String convertFileToString(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File can`t be read", e);
        }
        return builder.toString();
    }

    private static String[] extractInitialLetterWords(String[] inputArray, char initialLetter) {
        StringBuilder builder = new StringBuilder();
        for (String word : inputArray) {
            if (word.charAt(0) == initialLetter) {
                builder.append(word).append(System.lineSeparator());
            }
        }
        return builder.isEmpty() ? new String[0]
                : builder.toString().split(System.lineSeparator());
    }

    private static String[] getNaturallySortedArray(String[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i].compareTo(inputArray[j]) > 0) {
                    String temp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
        return inputArray;
    }

}
