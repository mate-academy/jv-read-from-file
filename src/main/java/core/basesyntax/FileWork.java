package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileWork {
    private static final String STARTING_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    if (startsWithW(word)) {
                        wordsStartingWithW.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collator collator = Collator.getInstance(Locale.getDefault());
        wordsStartingWithW.sort(collator);

        return wordsStartingWithW.toArray(new String[0]);

    }

    private boolean startsWithW(String word) {
        return word.toLowerCase().startsWith(STARTING_CHARACTER);
    }
}
