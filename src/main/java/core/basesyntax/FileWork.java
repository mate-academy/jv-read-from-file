package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase
                line = line.toLowerCase();

                // Split line into words using regex
                String[] words = line.split("\\W+");

                // Filter words starting with 'w'
                for (String word : words) {
                    if (word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort the list of words
        Collections.sort(wordsStartingWithW);

        // Convert the list to an array and return it
        return wordsStartingWithW.toArray(new String[0]);
    }
}
