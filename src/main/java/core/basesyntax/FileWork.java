package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] wordWithW = new String[100];
        int countWords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z\\s]", "");
                String[] wods = line.split("\\s+");
                for (String word : wods) {
                    if (word.toLowerCase().startsWith("w")) {
                        wordWithW[countWords++] = word.toLowerCase();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }

        String[] result = new String[countWords];
        for (int i = 0; i < countWords; i++) {
            result[i] = wordWithW[i];
        }
        Arrays.sort(result);
        return result;
    }
}
