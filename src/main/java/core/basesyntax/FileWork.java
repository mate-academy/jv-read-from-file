package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final int ZERO = 0;

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try {
            String content = String.join(" ", Files.readAllLines(Path.of(fileName)));

            String[] words = content
                    .toLowerCase()
                    .split("\\W+");

            for (String word : words) {
                if (!word.isEmpty() && word.startsWith("w")) {
                    result.add(word);
                }
            }

            Collections.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file", e);
        }

        return result.toArray(new String[0]);
    }
}
