package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public static final String NEED_CHAR = "w";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        try {
            List<String> data = Files.readAllLines(file.toPath());
            String text = data.toString();
            String[] words = text.toLowerCase().split("\\W+");
            for (String word : words) {
                if (word.startsWith(NEED_CHAR)) {
                    result.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        result.sort(null);
        return result.toArray(new String[0]);
    }
}
