package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {

        List<String> result;
        try {
            result = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> sortedResult = new ArrayList<>();
        for (String s : result) {
            sortedResult.addAll(Arrays.stream(s.split("\\W+"))
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith("w"))
                    .toList());
        }
        Collections.sort(sortedResult);
        return sortedResult.toArray(new String[0]);
    }
}
