package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String GIVEN_CHARACTER = "w";
    private static final String SPACE_REGEX = " ";
    private static final String SPLIT_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder targetWords = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split(SPLIT_REGEX);
                line = reader.readLine();
                for (String word : words) {
                    if (word.startsWith(GIVEN_CHARACTER)) {
                        targetWords.append(word).append(SPACE_REGEX);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (targetWords.length() == 0) {
            return new String[0];
        }
        String[] answer = targetWords.toString().split(SPACE_REGEX);
        Arrays.sort(answer);
        return answer;
    }
}
