package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] empty = new String[]{};
        StringBuilder readStrings = new StringBuilder();
        File test = new File(fileName);

        if (test.length() == 0) {
            return empty;
        } else {
            try {
                List<String> lines = Files.readAllLines(Path.of(fileName));
                String[] text = lines.toArray(new String[0]);
                for (String line : text) {
                    String[] temp = line.split(" ");
                    for (String word : temp) {
                        if (word.toLowerCase().startsWith("w")) {
                            readStrings.append(word).append(",");
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't read file");
            }
            String[] result = Stream.of(readStrings.toString().toLowerCase()
                    .replaceAll("[^a-z,]", "")
                    .split(",")).sorted().toArray(String[]::new);
            return (readStrings.length() == 0) ? empty : result;
        }
    }
}
