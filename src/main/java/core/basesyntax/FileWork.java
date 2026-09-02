package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            boolean hasContent = false;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    hasContent = true;
                    stringBuilder.append(line).append(" ");
                }
            }
            if (!hasContent) {
                return new String[0];
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] allWords = stringBuilder.toString().toLowerCase().split("\\W+");
        int count = 0;
        for (String word : allWords) {
            if (word.startsWith("w")) {
                count++;
            }
        }

        String[] results = new String[count];
        int index = 0;
        for (String word : allWords) {
            if (word.charAt(0) == 'w') {
                results[index] = word;
                index++;
            }
        }
        Arrays.sort(results);
        return results;
    }
} 
