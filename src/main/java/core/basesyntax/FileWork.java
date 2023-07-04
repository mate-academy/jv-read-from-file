package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        filteredWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        filteredWords.sort(String::compareToIgnoreCase);
        return filteredWords.toArray(new String[0]);
    }
}
