package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SPECIFIED_LOWER_CHARACTER = "w";
    private static final String SPECIFIED_UPPER_CHARACTER = "W";

    public String[] readFromFile(String fileName) {

        String[] words;
        ArrayList<String> filteredWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words = line.split("\\s+");
                for (String word : words) {

                    if (word.startsWith(SPECIFIED_UPPER_CHARACTER)
                            || word.startsWith(SPECIFIED_LOWER_CHARACTER)) {
                        filteredWords.add(word.toLowerCase());
                    }
                }
            }
            Collections.sort(filteredWords);
            filteredWords.replaceAll(s -> s.replaceAll("\\p{Punct}", ""));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return filteredWords.toArray(new String[0]);
    }
}
