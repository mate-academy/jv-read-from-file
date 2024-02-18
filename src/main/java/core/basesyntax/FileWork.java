package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;

public class FileWork {
    private static final String PUNCTUATION_MARKS = "[^a-zA-Z0-9\\s]";
    private static final String WHITESPACES_AND_LINE_BREAKS = "\\s+|\\n";
    private static final String SEARCH_FOR_IN_LOWER_CASE = "w";

    public String[] readFromFile(String fileName) {
        String content;
        Path path = Paths.get(fileName);
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        content = content.replaceAll(PUNCTUATION_MARKS, "");
        LinkedList<String> listWithWords = new LinkedList<>();
        for (String word : content
                .toLowerCase().split(WHITESPACES_AND_LINE_BREAKS)) {
            if (word.startsWith(SEARCH_FOR_IN_LOWER_CASE)) {
                listWithWords.add(word.toLowerCase().trim());
            }
        }
        Collections.sort(listWithWords);
        return listWithWords.toArray(new String[0]);
    }
}
