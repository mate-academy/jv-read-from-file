package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FileWork {
    private static final String SPLIT_WORDS_WITH = "\\W+";
    private static final String REMOVE_CHARACTERS = "[^A-Za-z0-9]";
    private static final String STARTING_WITH = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder contentsBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                contentsBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read a file ", e);
        }
        return getWordsWithLeadingLetterSorted(contentsBuilder.toString());
    }

    private String[] getWordsWithLeadingLetterSorted(String contents) {
        ArrayList<String> wordsWithLetter = new ArrayList<>();
        if (!contents.equals("")) {
            String[] words = contents.split(SPLIT_WORDS_WITH);
            for (String word : words) {
                if (word.startsWith(STARTING_WITH)
                        || word.startsWith(STARTING_WITH.toUpperCase(Locale.ROOT))) {
                    wordsWithLetter.add(word.toLowerCase().replaceAll(REMOVE_CHARACTERS, ""));
                }
            }
            Collections.sort(wordsWithLetter);
        }
        return wordsWithLetter.toArray(new String[0]);
    }
}
