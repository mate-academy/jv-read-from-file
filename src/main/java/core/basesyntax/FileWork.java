package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        //write your code here
        Path file = Paths.get(fileName);
        try {
            String fileString = Files.readString(file);
            String withoutPunctuation =
                    fileString.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
            String[] words = withoutPunctuation.split("\\s");
            return Arrays.stream(words)
                .filter(word -> word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}
