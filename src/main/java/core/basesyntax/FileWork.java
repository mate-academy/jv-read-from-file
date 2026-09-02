package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char TARGET_START_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = input.readLine()) != null) {
                result.addAll(extractWordsFromLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + fileName, e);
        }

        result.sort(null);
        return result.toArray(new String[0]);
    }

    private List<String> extractWordsFromLine(String line) {
        return Arrays.stream(line.split("\\W+"))
                .map(String::toLowerCase)
                .filter(word -> !word.isEmpty() && word.charAt(0) == FileWork.TARGET_START_CHAR)
                .toList();
    }
}
