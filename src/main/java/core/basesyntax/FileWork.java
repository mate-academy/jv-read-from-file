package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        Path path = Path.of(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
            StringBuilder linesAll = new StringBuilder();
            for (String line : lines) {
                linesAll.append(line).append(" ");
            }
            if (linesAll == null) {
                return new String[0];
            }
            String[] words = linesAll.toString().split("\\s+");
            for (String word : words) {
                String clean = word.replaceAll("\\p{Punct}", "").toLowerCase();
                if (clean.startsWith("w")) {
                    result.add(clean);
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
