package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> listOfWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        listOfWords.add(word.replaceAll("\\p{P}", ""));
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file...");
        }
        Collections.sort(listOfWords);
        return listOfWords.toArray(new String[]{});
    }
}
