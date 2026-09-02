package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("[.,!?;:\"()\\[\\]{}<>]", " ");
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + fileName, e);
        }

        if (wordsStartingWithW.isEmpty()) {
            return new String[0];
        }

        String[] result = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
