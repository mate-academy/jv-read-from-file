package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + fileName, e);
        }
        wordsStartingWithW.sort(null);
        return wordsStartingWithW.toArray(new String[0]);
    }

}
