package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileWork {
    private static final String WORDS_START = "w";

    public String[] readFromFile(String fileName) {
        String[] empty = new String[]{};
        StringBuilder readStrings = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            String[] text = lines.toArray(new String[0]);
            for (String line : text) {
                String[] temp = line.split(" ");
                for (String word : temp) {
                    if (word.toLowerCase().startsWith(WORDS_START)) {
                        readStrings.append(word).append(",");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] result = Stream.of(readStrings.toString().toLowerCase()
                .replaceAll("[^a-z,]", "")
                .split(",")).sorted().toArray(String[]::new);
        return (readStrings.length() == 0) ? empty : result;
    }
}
