package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_LETTER = "w";
    private static final String SPLIT_REGEX = "[^a-zA-Z]+";

    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.toLowerCase().split(SPLIT_REGEX);
                for (String word :parts) {
                    if (word.startsWith(SPECIFIED_LETTER)) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }

        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}
