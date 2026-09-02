package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                fileContent.append(value)
                        .append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't be read", e);
        }

        String[] words = fileContent
                .toString()
                .toLowerCase()
                .split("\\W+");

        int length = 0;
        for (String word : words) {
            if (!word.isBlank() && word.startsWith(SPECIFIED_CHARACTER)) {
                length++;
            } else if (word.isBlank()) {
                return new String[0];
            }
        }

        String[] wordsStartWithW = new String[length];
        int j = 0;
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                wordsStartWithW[j] = word;
                j++;
            }
        }
        Arrays.sort(wordsStartWithW);

        return wordsStartWithW;
    }
}
