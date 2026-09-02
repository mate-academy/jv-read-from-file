package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\W+");
                for (String word : lineWords) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        filteredWords.add(word.toLowerCase());
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
