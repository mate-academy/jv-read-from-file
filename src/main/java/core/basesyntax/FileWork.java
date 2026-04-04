package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        String text;
        try {
            text = Files.readString(path);
            String[] words = text.split("[\\s\\p{Punct}]+");
            List<String> result = new ArrayList<>();
            for (String word : words) {
                String lowerWord = word.toLowerCase();
                if (lowerWord.startsWith("w")) {
                    result.add(lowerWord);
                }

            }
            result.sort(null);
            return result.toArray(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
