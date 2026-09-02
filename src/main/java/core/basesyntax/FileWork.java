package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> words;
        try {
            String content = Files.readString(Paths.get(fileName));

            words = Arrays.stream(content.split("[\\s\\p{Punct}]+"))
                    .map(String::toLowerCase)
                    .filter(w -> w.startsWith("w"))
                    .toList();
        } catch (IOException e) {
            return new String[0];
        }

        if (words.isEmpty()) {
            return new String[0];
        }

        String[] result = words.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
