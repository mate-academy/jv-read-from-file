package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String LETTER_WORDS_SHOULD_STARTS_WITH = "w";
    private static final String DELIMITER = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {

                for (String word : value.split(DELIMITER)) {
                    if (word.toLowerCase().startsWith(LETTER_WORDS_SHOULD_STARTS_WITH)) {
                        result.add(word.toLowerCase().replaceAll("[!?,.]", ""));
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
