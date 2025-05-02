package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private static final String FILTER_WORD = "w";

    public String[] readFromFile(String fileName) {
        List<String> words = readWordsFromFile(fileName);
        List<String> list = filterList(words, FILTER_WORD);
        list.sort(String::compareTo);
        return list.toArray(new String[0]);
    }

    private List<String> filterList(List<String> list, String regexFilter) {
        List<String> result = new ArrayList<>();
        for (String word : list) {
            if (word.startsWith(regexFilter)) {
                result.add(word);
            }
        }
        return result;
    }

    private List<String> readWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.toLowerCase().split("\\W+");
                for (String word : lineWords) {
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }

        return words;
    }
}
