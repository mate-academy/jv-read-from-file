package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder currentWord = new StringBuilder();
        List<String> result = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new FileReader(fileName));
            int value = bufferedReader.read();
            while (value != -1) {
                currentWord.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = currentWord.toString().replaceAll("\\n", " ").split(" ");
        for (String word : words) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                result.add(word.toLowerCase().replaceAll("[^A-Za-z0-9]", ""));
            }
        }
        return result.stream().sorted().toArray(String[]::new);
    }
}


