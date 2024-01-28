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
            ArrayList<String> result = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    // Remove punctuation and convert to lowercase
                    String cleanedWord = word.replaceAll("[^a-zA-Z]",
                            "").toLowerCase();

                    // Check if the cleaned word starts with 'w'
                    if (cleanedWord.startsWith("w") && !cleanedWord.isEmpty()) {
                        result.add(cleanedWord);
                    }
                }
            }

            // Sort the result naturally
            Collections.sort(result);

            // Convert the ArrayList to an array
            return result.toArray(new String[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return an empty array if any exception occurs
        return new String[0];
    }
}
