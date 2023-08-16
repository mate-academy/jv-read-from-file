package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";
    public static final String REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitWords = line.split(REGEX);
                for (String word : splitWords) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
        Collections.sort(result);
        return result.toArray(new String[]{});
    }
}
