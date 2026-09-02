package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String PUNCTUATION_REGEX = "\\W+";
    private static final String SMALL_START_LETTER = "w";
    private static final String BIG_START_LETTER = "W";

    public String[] readFromFile(String fileName) {
        List<String> readLines;
        try {
            readLines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> resultList = new ArrayList<>();
        for (String currentLine : readLines) {
            String[] splitLines = currentLine.split(PUNCTUATION_REGEX);
            for (String currentSplitLine : splitLines) {
                if (currentSplitLine.startsWith(SMALL_START_LETTER)
                        || currentSplitLine.startsWith(BIG_START_LETTER)) {
                    resultList.add(currentSplitLine.toLowerCase());
                }
            }
        }
        Collections.sort(resultList);
        return resultList.toArray(new String[]{});
    }
}
