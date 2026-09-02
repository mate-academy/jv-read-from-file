package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    private static final Pattern DIVIDER_PATTERN = Pattern.compile("[ ,.!?]");
    private static final Pattern MATCHING_PATTERN = Pattern.compile("[wW][\\w-]+");

    public String[] readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            return findNeededWords(lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
    }

    private String[] findNeededWords(List<String> lines) {
        List<String> matchingWords = new ArrayList<>();
        for (String line : lines) {
            for (String word : DIVIDER_PATTERN.split(line)) {
                if (MATCHING_PATTERN.matcher(word).matches()) {
                    matchingWords.add(word.toLowerCase());
                }
            }
        }
        String[] matchingWordsArray = new String[matchingWords.size()];
        Arrays.sort(matchingWords.toArray(matchingWordsArray));
        return matchingWordsArray;
    }
}
