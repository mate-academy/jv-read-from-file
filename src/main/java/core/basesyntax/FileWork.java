package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line.toLowerCase()).append(" ");
            }
            String[] words = stringBuilder.toString().split("[\\p{Punct}\\s]+");
            String[] filteredWords = Arrays.stream(words)
                    .filter(w -> w.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);

            return filteredWords;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
