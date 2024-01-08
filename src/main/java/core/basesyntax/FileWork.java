package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String filePath) {
        List<String> wordStartingWithW = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty() && word.startsWith(SPECIFIED_CHARACTER)) {
                    wordStartingWithW.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }

        Collections.sort(wordStartingWithW);
        return wordStartingWithW.toArray(new String[0]);
    }
}
