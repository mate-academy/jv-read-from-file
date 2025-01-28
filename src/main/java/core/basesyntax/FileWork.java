package core.basesyntax;

import java.io.*;
import java.util.*;

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
        return wordsStartingWithW.isEmpty() ? new String[0] : wordsStartingWithW.toArray(new String[0]);
    }
}
