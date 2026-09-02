package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleanedWord = word
                            .replaceAll("^[^A-Za-z0-9]+|[^A-Za-z0-9]+$", "")
                            .toLowerCase();
                    if (cleanedWord.startsWith(START_LETTER)) {
                        filteredWords.add(cleanedWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }

        filteredWords.sort(String::compareTo);
        return filteredWords.toArray(new String[0]);
    }
}
