package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        result.append(word).append(" ");
                    }
                }
            }
            if (result.length() == 0) {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] filteredWords = result.toString().split("\\s+");

        Arrays.sort(filteredWords);

        return filteredWords;
    }
}
