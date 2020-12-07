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
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] wordsArray = value.split(" ");
                for (String word: wordsArray) {
                    word = word.toLowerCase();
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        words.add(word.replaceAll("\\W", ""));
                    }
                }
                value = bufferedReader.readLine();
            }
            Collections.sort(words);
            return words.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
