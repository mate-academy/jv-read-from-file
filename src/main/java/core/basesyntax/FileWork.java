package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            bufferedReader.lines().forEach(line -> {
                for (String word : line.split("\\W+")) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        result.add(word.toLowerCase());
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }

        result.sort(String::compareTo);
        return result.toArray(new String[0]);
    }
}
