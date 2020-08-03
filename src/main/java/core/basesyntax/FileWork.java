package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    static final String W_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> resultList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName));

            for (String line: lines) {
                String[] words = line.toLowerCase().replaceAll("[^a-z]"," ").split("\\W+");
                for (String word: words) {
                    if (word.startsWith(W_LETTER)) {
                        resultList.add(word);
                    }
                }
            }
            Collections.sort(resultList);
            String[] result = new String[resultList.size()];
            return resultList.toArray(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
