package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char SEARCHED_LETTER = 'w';
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                for (String word : line.split(SEPARATOR)) {
                    if (word.toLowerCase().charAt(0) == SEARCHED_LETTER) {
                        result.add(word.toLowerCase().replaceAll("\\p{P}", ""));
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(result);

        return result.toArray(new String[0]);
    }
}
