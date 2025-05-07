package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> fileData;
        try {
            fileData = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file", e);
        }
        List<String> resultData = new ArrayList<>();
        for (String line : fileData) {
            String[] wordArray = line.toLowerCase().split("\\W+");
            for (String word:wordArray) {
                if (word.startsWith("w")) {
                    resultData.add(word);
                }
            }
        }
        Collections.sort(resultData);
        return resultData.toArray(new String[0]);
    }
}
