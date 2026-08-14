package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        if (fileName.isEmpty()) {
            return new String[0];
        }
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            for (String line : strings) {
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (word.toLowerCase().startsWith("w")) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        String[] array = result.toArray(new String[0]);
        Arrays.sort(array);
        return array;
    }
}
