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
        List<String> wordsW = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Path.of(fileName)));
            String[] words = content.toLowerCase().split("[\\W]+");

            for (String word : words) {
                if (word.startsWith("w")) {
                    wordsW.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] result = wordsW.toArray(new String[0]);
        Arrays.sort(result);
        return result;

    }
}
