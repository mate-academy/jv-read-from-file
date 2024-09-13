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
                stringBuilder.append(line).append(" ");
            }
            return processText(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file", e);
        }
    }

    private String[] processText(String text) {
        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = text.split("\\s+");

        int count = 0;
        for (String word : words) {
            if (word.startsWith("w")) {
                count++;
            }
        }

        if (count == 0) {
            return new String[]{};
        }

        String[] result = new String[count];
        int index = 0;
        for (String word : words) {
            if (word.startsWith("w")) {
                result[index++] = word;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
