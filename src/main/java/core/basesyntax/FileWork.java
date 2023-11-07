package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<String> wordsStartingWithW = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (word.startsWith("w") && !word.isEmpty()) {
                        wordsStartingWithW.add(word);
                    }
                }
            }

            Collections.sort(wordsStartingWithW);
            return wordsStartingWithW.toArray(new String[0]);

        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}

