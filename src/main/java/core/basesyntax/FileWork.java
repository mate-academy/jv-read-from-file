package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        List<String> result = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(file.toPath());

            for (String line : lines) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        result.add(word.toLowerCase(Locale.ROOT));
                    }
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
