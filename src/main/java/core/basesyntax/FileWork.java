package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            if (lines.isEmpty()) {
                return new String[]{};
            }
            for (String line : lines) {
                String[] splitWords = line.toLowerCase().split("\\W+");
                for (String word : splitWords) {
                    if (word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] resultArray = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
