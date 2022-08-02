package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private StringBuilder builder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String value = reader.readLine();
            while (value != null) {
                findWords(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] sortedValue = new String[0];

        if (!builder.toString().isEmpty()) {
            sortedValue = builder.toString().split(" ");
            Arrays.sort(sortedValue);
        }
        return sortedValue;
    }

    private void findWords(String words) {
        for (String word : words.split(" ")) {
            if (word.toLowerCase().startsWith("w")) {
                String formattedWord = word.toLowerCase().replaceAll("[^a-z]", "");
                builder.append(formattedWord).append(" ");
            }
        }
    }
}
