package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            return lines.stream()
                    .flatMap(line -> Arrays.stream(line.split("\\W")))
                    .map(String::toLowerCase)
                    .filter(word -> word.matches("^w.+"))
                    .sorted()
                    .toList()
                    .toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Can't read file!");
        }
        return new String[0];
    }
}
