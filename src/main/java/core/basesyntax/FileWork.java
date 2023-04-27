package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String content = builder.toString();
            String contentLowerCase = content.replaceAll("[^\\w\\s]", "").toLowerCase();
            String[] words = contentLowerCase.split("\\s+");
            words = Arrays.stream(words)
              .filter(word -> word.startsWith(FIRST_LETTER))
              .toArray(String[]::new);
            Arrays.sort(words);
            return words;

        } catch (IOException e) {
            throw new RuntimeException("Cant read file:", e);
        }
    }
}
