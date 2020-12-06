package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER_LOWER_CASE = "w";
    private static final String SPECIFIED_CHARACTER_UPPER_CASE = "W";
    private List<String> notFormattedWords = new ArrayList<>();

    public String[] readFromFile(String fileName) throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                String[] notSortedList = value.split(" ");
                for (String word : notSortedList) {
                    if (word.startsWith(SPECIFIED_CHARACTER_LOWER_CASE)
                            || word.startsWith(SPECIFIED_CHARACTER_UPPER_CASE)) {
                        notFormattedWords.add(word.toLowerCase().replaceAll("\\W", ""));
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        Collections.sort(notFormattedWords);
        String[] sortedWords = new String[notFormattedWords.size()];
        for (int i = 0; i < notFormattedWords.size(); i++) {
            sortedWords[i] = notFormattedWords.get(i);
        }
        return sortedWords;
    }
}
