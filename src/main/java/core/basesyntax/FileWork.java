package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER_LOWER_CASE = "w";

    public String[] readFromFile(String fileName) {
        List<String> notFormattedWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                String[] notSortedList = value.toLowerCase().split(" ");
                for (String word : notSortedList) {
                    if (word.startsWith(SPECIFIED_CHARACTER_LOWER_CASE)) {
                        notFormattedWords.add(word.replaceAll("\\W", ""));
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(notFormattedWords);
        String[] sortedWords = notFormattedWords.toArray(new String[notFormattedWords.size()]);
        return sortedWords;
    }
}
