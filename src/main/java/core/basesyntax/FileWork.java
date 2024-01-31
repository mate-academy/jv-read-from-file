package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPLIT = "\\W+";
    private static final char CHAR_W = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            if (strings == null || strings.isEmpty()) {
                return new String[0];
            }
            List<String> wordsStartingWithW = new ArrayList<>();
            for (String line : strings) {
                String[] splitStringToLowerCaseArray = line.toLowerCase().split(SPLIT);
                for (String word : splitStringToLowerCaseArray) {
                    if (word.length() > 0 && word.charAt(0) == CHAR_W) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
            Collections.sort(wordsStartingWithW);
            String[] resultArray = wordsStartingWithW.toArray(new String[0]);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ", e);
        }
    }
}
