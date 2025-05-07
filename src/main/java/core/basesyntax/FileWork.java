package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    private static final String spearChar = "W";

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        List<String> result = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", " ").toLowerCase().trim();
                    if (startWithLetter(word)) {
                        result.add(word);
                    }
                }
            }
            Collections.sort(result);

        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
        return result.toArray(new String[0]);
    }

    public boolean startWithLetter(String word) {
        String lowerCaseWord = word.toLowerCase();
        return lowerCaseWord.startsWith(spearChar.toLowerCase());
    }
}
