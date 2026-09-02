package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {

        Path filePath = Path.of(fileName);
        String content;
        try {
            content = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> list = Arrays.asList(content.split("[^a-zA-Z]"));
        list = list
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("w"))
                .sorted().toList();

        return list.toArray(new String[0]);
    }
}
