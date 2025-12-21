package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path pathOfTest = Path.of(fileName);
        List<String> words = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(pathOfTest);
            for (String eachWord : lines) {
                String[] tokens = eachWord.toLowerCase().split("\\W+");
                for (String token : tokens) {
                    if (token.isEmpty()) {
                        continue;
                    }
                    if (token.charAt(0) == 'w') {
                        words.add(token);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words.toArray(new String[0]);
    }
}
