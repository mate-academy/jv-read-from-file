package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIAL_CHARACTERS = "[,.\\s\\-:?!]";

    public String[] readFromFile(String fileName) {
        StringBuilder filteredWords = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                filteredWords.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        String[] array = filteredWords.toString().split(SPECIAL_CHARACTERS);
        int countWithLetterW = 0;
        for (String word : array) {
            if (startWithLetter(word)) {
                countWithLetterW++;
            }
        }

        int i = 0;
        String[] startWithW = new String[countWithLetterW];
        for (String word : array) {
            if (startWithLetter(word)) {
                startWithW[i] = word;
                i++;
            }
        }

        Arrays.sort(startWithW);
        return startWithW;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
