package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String LETTER_WORDS_SHOULD_START_WITH = "w";
    private static final String DELIMITER = " ";
    private static final String REGEX = "[!?,.]";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            for (String line = bufferedReader.readLine(); line != null;
                    line = bufferedReader.readLine()) {
                for (String word : line.split(DELIMITER)) {
                    if (word.toLowerCase().startsWith(LETTER_WORDS_SHOULD_START_WITH)) {
                        result.add(word.toLowerCase().replaceAll(REGEX, ""));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write write data to file" + fileName, e);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
