package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String filePath) {

        List<String> wordsStartingWithW = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words)  {
                    if (word.toLowerCase().startsWith("w")) {
                        wordsStartingWithW.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Problem read file: " + e.getMessage());
        }
        if (wordsStartingWithW.isEmpty()) {
            return new String[0];
        }
        Collections.sort(wordsStartingWithW);
        return wordsStartingWithW.toArray(new String[0]);

        }

    }


