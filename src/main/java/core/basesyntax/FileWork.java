package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String textFromFile = null;

        try {
            textFromFile = Files.readAllLines(Path.of(fileName)).toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("File does not exists", e);
        }

        String[] words = textFromFile.split("\\W+");
        String[] result = Arrays.stream(words)
                .filter(word -> word.length() > 0 && word.charAt(0) == 'w')
                .toArray(String[]::new);
        Arrays.sort(result);

        return result;
    }
}
