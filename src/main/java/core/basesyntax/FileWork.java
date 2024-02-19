package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX = "\\W+";
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }

            String[] result = validWords(stringBuilder.toString().split(REGEX));
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    private static boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    private static int countLength(String[] sentence) {
        int counter = 0;

        for (String word : sentence) {
            if (startWithLetter(word.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }

    private static String[] validWords(String[] array) {
        String[] validatedWords = new String[countLength(array)];

        int validWordPosition = 0;
        for (String word : array) {
            if (startWithLetter(word.toLowerCase())) {
                validatedWords[validWordPosition] = word.toLowerCase();
                validWordPosition++;
            }
        }

        return validatedWords;
    }
}
