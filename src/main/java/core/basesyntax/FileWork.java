package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> allLines;
        try {
            allLines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file", e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : allLines) {
            stringBuilder.append(line).append(" ");
        }
        String result = stringBuilder.toString().toLowerCase();
        String[] words = result.split("\\W");
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (word.matches("[w][a-z]+")) {
                filteredWords.add(word);
            }
        }
        String[] filteredWordsArray = filteredWords.toArray(new String[0]);
        Arrays.sort(filteredWordsArray);
        return filteredWordsArray;
    }
}
