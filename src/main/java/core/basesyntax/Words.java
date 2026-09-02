package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Words {
    public String[] readFromFile(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            return new String[0];
        }

        List<String> result = new ArrayList<>();

        for (String line : lines) {
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                    result.add(word.toLowerCase());
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
