package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        // Створимо список для зберігання слів
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    String cleanedToken = token.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (cleanedToken.startsWith("w")) {
                        words.add(cleanedToken);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from FileReader: " + e);
        }
        words.sort(String::compareTo);
        return words.toArray(new String[0]);
    }
}






