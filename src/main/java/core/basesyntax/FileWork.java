package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        return null;
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            List<String> wordsStartingWithW = new ArrayList<>();

            for (String line : lines) {
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        wordsStartingWithW.add(word.toLowerCase());
                    }
                }
            }

            String[] result = wordsStartingWithW.toArray(new String[0]);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred", e);
        }
    }
}

