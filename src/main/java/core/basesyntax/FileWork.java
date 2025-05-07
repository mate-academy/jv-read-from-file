package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        List<String> res = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w") || word.startsWith("W")) {
                        res.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + fileName, e);
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}
