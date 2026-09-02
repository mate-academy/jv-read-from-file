package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line : lines) {
                String[] words = line.split("[\\s.,!?;:\"()]+");
                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        wordsStartingWithW.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] result = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
