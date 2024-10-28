package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] filteredWords = sortingWords(value);
                for (String word : filteredWords) {
                    stringBuilder.append(word).append(" ");
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().trim().split(" ");
        Arrays.sort(result);
        return result;
    }

    public String[] sortingWords(String value) {
        String[] words = value.split("\\W+");
        int count = 0;

        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] result = new String[count];
        int index = 0;

        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                result[index++] = word.toLowerCase();
            }
        }
        Arrays.sort(result);
        return result;
    }
}
