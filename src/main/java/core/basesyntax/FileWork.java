package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final String regex = "\\W+";
    private static final String startingCharacter = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        Path path = Path.of(fileName);
        List<String> result = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                for (String word : line.split(regex)) {
                    if (word.toLowerCase().startsWith(startingCharacter)) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result.sort(Comparator.naturalOrder());
        return result.toArray(new String[]{});
    }
}
