package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String EXCEPTION_MESSAGE = "Can't read file";

    public String[] readFromFile(String fileName) {
        Path testFile = Path.of(fileName);
        String[] resultArray;

        try {
            List<String> lines = Files.readAllLines(testFile);
            List<String> linesList = Arrays.asList(String.valueOf(lines)
                    .toLowerCase().split("\\W+"));
            List<String> wordsList = new ArrayList<>(List.of());
            for (String word : linesList) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    wordsList.add(word);
                }
            }
            Collections.sort(wordsList);
            resultArray = wordsList.toArray(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE, e);
        }

        return resultArray;
    }
}
