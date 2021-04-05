package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPLIT_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String stringOfFile = bufferedReader.readLine();
            while (stringOfFile != null) {
                String[] splitString = stringOfFile.split(SPLIT_REGEX);
                for (String word : splitString) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        result.add(word.toLowerCase());
                    }
                }
                stringOfFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
