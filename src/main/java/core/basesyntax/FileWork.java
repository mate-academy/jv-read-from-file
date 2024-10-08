package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingW = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] words = content.toLowerCase().split("[\\W]+");

            for (String word : words) {
                if (word.startsWith("w")) {
                    wordsStartingW.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] result = wordsStartingW.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
