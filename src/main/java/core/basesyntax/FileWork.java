package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from file", e);
        }

        String[] words = stringBuilder.toString().trim().split("\\W+");
        StringBuilder wordsOnW = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("W") || word.startsWith("w")) {
                wordsOnW.append(word.toLowerCase()).append(" ");
            }
        }

        String filtered = wordsOnW.toString().trim();
        if (filtered.isEmpty()) {
            return new String[0];
        }

        String[] result = filtered.split("\\W+");
        Arrays.sort(result);

        return result;
    }
}
