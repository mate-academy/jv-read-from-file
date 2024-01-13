package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_LETTER_INDEX = 0;
    private static final int EMPTY_ARRAY_LENGTH = 0;
    private static final char WORD_FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        return getResultArray(fileName);
    }

    private String[] getResultArray(String fileName) {
        File file = new File(fileName);
        StringBuilder fileText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                fileText.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        if (!fileText.isEmpty()) {
            return sortArray(lookForLetter(fileText));
        } else {
            return new String[EMPTY_ARRAY_LENGTH];
        }

    }

    private StringBuilder lookForLetter(StringBuilder fileText) {
        String[] textArray = fileText.toString().toLowerCase().split("[\\s\\p{Punct}]+");
        StringBuilder builder = new StringBuilder();
        for (String word : textArray) {
            if (word.charAt(FIRST_LETTER_INDEX) == WORD_FIRST_LETTER) {
                builder.append(word).append(" ");
            }
        }
        return builder;
    }

    private String[] sortArray(StringBuilder chosenWords) {
        if (chosenWords.isEmpty()) {
            return new String[EMPTY_ARRAY_LENGTH];
        } else {
            String[] resultArray = chosenWords.toString().split(" ");
            Arrays.sort(resultArray);
            return resultArray;
        }
    }
}
