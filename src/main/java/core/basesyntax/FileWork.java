package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            List<String> linesFromFile = Files.readAllLines(Paths.get(fileName));
            if (linesFromFile.isEmpty()) {
                return new String[0];
            }

            List<String> result = new ArrayList<>();

            for (String line : linesFromFile) {
                String[] words = line.split("\\W+");

                for (String word : words) {

                    if (word.toLowerCase().startsWith("w")) {
                        result.add(word.toLowerCase());
                    }
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }
    }
}
