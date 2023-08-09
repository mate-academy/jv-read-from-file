package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\W+", " ");
                String[] words = line.toLowerCase().split(" ");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        filteredWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        filteredWords.sort(String::compareToIgnoreCase);
        return new String[filteredWords.size()];
    }
}
