package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String TARGET_LETTER = "w";

    public String[] readFromFile(String fileName) {
        String[] wordStartingWithW = new String[100];
        int countWordsWithW = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z\\s]", "");
                String[] words = line.split("\\s");
                for (String word : words) {
                    if (word.toLowerCase().startsWith(TARGET_LETTER)) {
                        wordStartingWithW[countWordsWithW++] = word.toLowerCase();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't reed file!", e);
        }

        String[] result = new String[countWordsWithW];
        for (int i = 0; i < countWordsWithW; i++) {
            result[i] = wordStartingWithW[i];
        }
        Arrays.sort(result);
        return result;
    }
}
