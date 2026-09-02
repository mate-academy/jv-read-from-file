package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;


class Words {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (!word.isEmpty() && word.toLowerCase().startsWith("w")){
                    result.add(word.toLowerCase());
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}