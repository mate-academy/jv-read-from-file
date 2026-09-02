package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    if (word.toLowerCase().startsWith("w")) {
                        filteredWords.add(word.replaceAll("[^a-zA-Z]", "").toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(filteredWords);
        return filteredWords.toArray(new String[0]);
    }
}
