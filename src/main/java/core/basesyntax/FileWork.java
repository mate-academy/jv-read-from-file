package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String LOWER_GIVEN_CHARACTER = "w";
    private static final String UPPER_GIVEN_CHARACTER = "W";
    private static final String SPACE_REGEX = " ";
    private static final String EMPTY_REGEX = "";
    private static final String PUNCTUATION_REGEX = "\\p{P}";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder targetWords = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(SPACE_REGEX);
                line = reader.readLine();
                for (String word : words) {
                    if (word.startsWith(LOWER_GIVEN_CHARACTER)
                            || word.startsWith(UPPER_GIVEN_CHARACTER)) {
                        targetWords.append(word.toLowerCase()
                                .replaceAll(PUNCTUATION_REGEX, EMPTY_REGEX)).append(SPACE_REGEX);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (targetWords.toString().equals(EMPTY_REGEX)) {
            return new String[0];
        }
        String[] answer = targetWords.toString().split(SPACE_REGEX);
        Arrays.sort(answer);
        return answer;
    }
}
