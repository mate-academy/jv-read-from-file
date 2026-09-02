package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public static void main(String[] args) {

    }

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            String[] words = content.split("\\W+");
            List<String> filteredWords = new ArrayList<>();

            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    filteredWords.add(word.toLowerCase());
                }
            }

            Collections.sort(filteredWords);
            return filteredWords.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read files", e);
        }
    }
}
