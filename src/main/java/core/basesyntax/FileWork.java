package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final String SEARCHING_LETTER = "w";
    private static final String WORDS_REGEX = "[^a-zA-Z]";

    public String[] readFromFile(String fileName) {
        String content;
        List<String> filteredWords = new ArrayList<>();

        try {
            content = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + fileName, e);
        }

        if (content != null) {
            String[] words = content.toLowerCase().split(WORDS_REGEX);

            for (String word : words) {
                if (word.startsWith(SEARCHING_LETTER)) {
                    filteredWords.add(word);
                }
            }

            filteredWords.sort(Comparator.naturalOrder());
        }

        return filteredWords.toArray(new String[0]);
    }
}
