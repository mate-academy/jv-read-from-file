package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Зробити все в нижньому регістрі, видалити пунктуацію
                String cleanedLine = line.toLowerCase().replaceAll("[^a-z\\s]", "");
                String[] words = cleanedLine.split("\\s+");

                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        filteredWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
