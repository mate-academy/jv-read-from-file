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
                for (String word : line.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+")) {
                    if (word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        if (wordsStartingWithW.isEmpty()) {
            return new String[0];
        }
        Collections.sort(wordsStartingWithW);
        return wordsStartingWithW.toArray(new String[0]);

        }

    public String[] readFromFile() {
        return new String[0];
    }
}
