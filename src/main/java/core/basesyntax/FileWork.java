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
        List<String> words = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineWords = bufferedReader.readLine();
            while (lineWords != null) {
                String[] line = lineWords.toLowerCase().split("[^\\w]");
                for (String word : line) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        words.add(word);
                    }
                }
                lineWords = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file", e);
        }
        Collections.sort(words);
        String[] newArray = new String[0];
        return words.toArray(newArray);
    }
}

