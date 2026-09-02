package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append(Files.readString(Path.of(fileName)).toLowerCase());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = builder.toString().split("\\W+");
        Arrays.sort(words);
        builder.setLength(0);
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("w")) {
                builder.append(words[i]).append(" ");
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        return builder.toString().split(" ");
    }
}
