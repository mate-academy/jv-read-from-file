package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {
        List<String> filterWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^-zA-Z]", "").toLowerCase();
                    if (cleanedWord.startsWith("w")) {
                        filterWords.add(cleanedWord);
                        
                    }
                }
            }
        }

        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new String[0];
        }

        Collections.sort(filterWords);
        return filterWords.toArray(new String[0]);
    }

    public static void main(String[] args){}
}