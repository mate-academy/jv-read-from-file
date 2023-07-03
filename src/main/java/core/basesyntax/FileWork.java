package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {
        List<String> listOfWordsStartsWithW = new ArrayList<>();
        String[] words = getLinesFromFile(fileName).toLowerCase().split("\\W+");
        for (String word: words) {
            if (word.startsWith("w")) {
                listOfWordsStartsWithW.add(word);
            }
        }
        Collections.sort(listOfWordsStartsWithW);
        return listOfWordsStartsWithW.toArray(new String[0]);
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
