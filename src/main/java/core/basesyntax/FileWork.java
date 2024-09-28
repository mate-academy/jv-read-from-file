package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";
    public static final String WORDS_DELIMITER = "-";
    public static final String REGEX_WORD_DIVIDER = "\\W+";
    public static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Data can't be read", e);
        }
        String[] wordsSplit = String.valueOf(stringBuilder).toLowerCase().split(REGEX_WORD_DIVIDER);
        StringBuilder wordsStartWithSpecifiedCharacter = new StringBuilder();
        for (String word : wordsSplit) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                wordsStartWithSpecifiedCharacter.append(word).append(WORDS_DELIMITER);
            }
        }
        if (wordsStartWithSpecifiedCharacter.isEmpty() || String.valueOf(
                wordsStartWithSpecifiedCharacter).isBlank()) {
            return EMPTY_ARRAY;
        }
        String[] result = String.valueOf(wordsStartWithSpecifiedCharacter).split(WORDS_DELIMITER);
        Arrays.sort(result);
        return result;
    }
}
