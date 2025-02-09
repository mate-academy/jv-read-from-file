package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try {
            String content = Files.readString(Path.of(fileName));
            String[] words = content.split("[^a-zA-Z]+");

            return Arrays.stream(words)
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("read from file error:" + e);
            return new String[0];
        }
    }
}
