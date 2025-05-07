package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_LETTER_FOR_WORDS_SELECTION = 'w';
    private static final String REGEX_FOR_DIVIDING = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't open", e);
        }

        String[] words = stringBuilder.toString().split(REGEX_FOR_DIVIDING);
        String[] selectedWords = getArrayOfSelectedWords(words, FIRST_LETTER_FOR_WORDS_SELECTION);
        Arrays.sort(selectedWords);

        return selectedWords;
    }

    private String[] getArrayOfSelectedWords(String[] words, char firstLetter) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (words[i].length() == 0) {
                return new String[0];
            } else if (words[i].charAt(0) == firstLetter) {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] selectedWords = new String[count];
        count = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == firstLetter) {
                selectedWords[count] = words[i];
                count++;
            }
        }
        return selectedWords;
    }
}
