package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String CHAR_AT_START = "w";

    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (word.startsWith(CHAR_AT_START)) {
                        wordsList.add(word);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        Collections.sort(wordsList);
        return wordsList.toArray(new String[] {});
    }
}
