package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\p{Punct}\\s]+");
                for (String word : words) {
                    String lowercaseWord = word.toLowerCase().replaceAll("[\\p{Punct}]", "");
                    if (lowercaseWord.startsWith(SPECIFIED_CHARACTER)) {
                        filteredWords.add(lowercaseWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("cant read test", e);
        }
        filteredWords.sort(String.CASE_INSENSITIVE_ORDER);
        return filteredWords.toArray(new String[0]);
    }
}


