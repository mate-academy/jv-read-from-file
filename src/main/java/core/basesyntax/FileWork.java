package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.trim().toLowerCase()).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("error", e);
        }

        String[] words = content.toString().split("[^a-zA-Z0-9]+");
        int numOfWords = 0;

        for (String word : words) {
            if (word.startsWith("w")) {
                numOfWords++;
            }
        }

        String[] result = new String[numOfWords];
        int i = 0;

        for (String word : words) {
            if (word.startsWith("w")) {
                result[i] = word;
                i++;
            }
        }

        Arrays.sort(result);

        return result;
    }
}
