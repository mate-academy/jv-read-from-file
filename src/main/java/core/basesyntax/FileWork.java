package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        try {
            String content = Files.readString(path);

            String[] words = content.toLowerCase().split("[\\s\\p{Punct}]+");

            List<String> result = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                if (!words[i].startsWith("w")) {
                    continue;
                }
                result.add(words[i]);
            }

            result.sort(null);

            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + fileName, e);
        }

    }
}
