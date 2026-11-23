package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try {
            String text = Files.readString(Path.of(fileName));
            String[] words = text.split("[\\s\\p{Punct}]+");
            for (String word : words) {
                String lowerWord = word.toLowerCase();

                if (lowerWord.startsWith("w")) {
                    result.add(lowerWord);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
