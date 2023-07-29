package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> wordsArray = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^\\p{L}\\p{N}]", ""); // Remove punctuation
                    if (!word.isEmpty() && (word.startsWith("w") || word.startsWith("W"))) {
                        wordsArray.add(word.toLowerCase());
                    }
                }
                line = reader.readLine();
            }
            reader.close();
            Collections.sort(wordsArray);
            return wordsArray.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
