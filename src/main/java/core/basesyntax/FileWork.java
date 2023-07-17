package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String[] words = stringBuilder.toString().split("\\s+");
            String[] filteredWords = new String[words.length];
            int count = 0;
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    filteredWords[count] = word.toLowerCase().replaceAll("[^a-z]", "");
                    count++;
                }
            }
            Arrays.sort(filteredWords, 0, count);
            String[] result = Arrays.copyOf(filteredWords, count);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("File can't be read", e);
        }
    }
}
