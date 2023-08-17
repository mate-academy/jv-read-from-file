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
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[]words = fileName.split("\\W+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        result.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        Collections.sort(result);
        return result.toArray(new String[]{});
    }
}
