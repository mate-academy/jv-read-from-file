package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHAR = "w";
    private final StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                line = line.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHAR)) {
                        builder.append(word).append(" ");
                    }
                }
                line = reader.readLine();
            }
            if (builder.length() == 0) {
                return new String[0];
            }
            String[] filteredWords = builder.toString().trim().split("\\s+");
            if (filteredWords.length == 0) {
                return new String[0];
            }
            Arrays.sort(filteredWords);
            return filteredWords;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file ", e);
        }
    }
}
