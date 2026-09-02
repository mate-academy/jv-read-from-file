package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s.,!?]+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-letter characters
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        wordsStartingWithW.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordsStartingWithW.stream()
                .sorted()
                .toArray(String[]::new);
    }
}
