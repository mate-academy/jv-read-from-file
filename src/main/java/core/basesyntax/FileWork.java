package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        if (builder.length() == 0) {
            return new String[0];
        }

        String[] words = builder.toString().split("\\W+");
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = word.charAt(0);
                if (firstChar == 'w' || firstChar == 'W') {
                    filteredWords.add(word.toLowerCase());
                }
            }
        }

        if (filteredWords.isEmpty()) {
            return new String[0];
        }

        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result);

        return result;
    }
}
