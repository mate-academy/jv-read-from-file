package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName == null) {
            return new String[0];
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }

            String[] words = builder.toString().toLowerCase(Locale.ROOT).split("\\W+");
            return Arrays.stream(words)
                    .filter(word -> !word.isEmpty())
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);

        } catch (IOException e) {
            throw new RuntimeException("Can't read a file:" + fileName, e);
        }
    }
}
