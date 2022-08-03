package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER_OF_WORD = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        Path path = file.toPath();
        String[] words;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            words = Files.readAllLines(path)
                    .toString()
                    .toLowerCase()
                    .replaceAll("[^a-z0-9 ]", "")
                    .split(" ");
        } catch (IOException e) {
            throw new RuntimeException("Problem with read file ", e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(FIRST_LETTER_OF_WORD)) {
                stringBuilder.append(word)
                        .append(" ");
            }
        }
        words = stringBuilder.toString()
                .split(" ");

        if (words.length <= 1) {
            return new String[0];
        }

        Arrays.sort(words);
        return words;
    }
}
