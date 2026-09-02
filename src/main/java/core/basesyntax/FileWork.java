package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPACE = " ";
    private static final String NON_LETTER_CHARACTERS_REGEX = "[^a-zA-Z ]";
    private static final String EMPTY_STRING = "";
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String lineFromFile;
            while ((lineFromFile = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineFromFile).append(SPACE);
            }
            String preparedString = stringBuilder.toString().trim()
                    .replaceAll(NON_LETTER_CHARACTERS_REGEX, EMPTY_STRING).toLowerCase();
            String[] wordsArray = preparedString.split(WHITESPACE_REGEX);
            int index = 0;
            for (int i = 0; i < wordsArray.length; i++) {
                String word = wordsArray[i];
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    if (index != i) {
                        wordsArray[index] = word;
                    }
                    index++;
                }
            }
            String[] result = Arrays.copyOf(wordsArray, index);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
