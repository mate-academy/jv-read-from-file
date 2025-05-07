package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[^a-zA-Z]+");
                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(wordsStartingWithW);
        if (wordsStartingWithW.isEmpty()) {
            return new String[0];
        }
        return wordsStartingWithW.toArray(new String[0]);
    }
}
