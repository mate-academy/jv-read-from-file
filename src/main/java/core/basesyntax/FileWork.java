package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> listStartsFromW = new ArrayList<>();
        String[] words = getLinesFromFile(fileName).toLowerCase().split("\\W+");
        for (String word: words) {
            if (word.startsWith("w")) {
                listStartsFromW.add(word);
            }
        }
        Collections.sort(listStartsFromW);
        return listStartsFromW.toArray(new String[0]);
    }

    public static String getLinesFromFile(String filename) {
        try {
            List<String> listOfLines = Files.readAllLines(Path.of(filename));
            return String.valueOf(listOfLines);
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file", e);
        }
    }
}
