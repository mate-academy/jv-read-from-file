package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class FileWork {
    public String [] readFromFile(String fileName) {
        String text = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            text = new String(bytes, StandardCharsets.UTF_8).toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = text.split("[\\p{Punct}\\s]+");
        return Arrays.stream(words)
                .filter(word -> word.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
