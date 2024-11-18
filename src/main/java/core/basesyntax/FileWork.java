package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();

        try {

            String content = Files.readString(Path.of(fileName));

            String[] words = content.toLowerCase()
                    .replaceAll("[^a-z\\s]", "")
                    .split("\\s+");

            for (String word : words) {
                if (word.startsWith("w")) {
                    wordsList.add(word);
                }
            }

            Collections.sort(wordsList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return the list as an array
        return wordsList.toArray(new String[0]);
    }
}
