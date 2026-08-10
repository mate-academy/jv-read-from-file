package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }

        if (builder.length() == 0) {
            return new String[0];
        }

        String[] parts = builder.toString()
                .toLowerCase()
                .split("[\\s\\p{Punct}]+");

        String[] result = new String[0];

        for (String word : parts) {
            if (word.charAt(0) == 'w' && !word.isEmpty()) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = word;
            }
        }

        Arrays.sort(result);
        return result;
    }
}


