package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REPLACEMENT = "";
    private static final String WITE_SPACE_REGEX = " ";
    private static final String NON_LETTERS_REGEX = "[^a-zA-Z]";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> allLineFromFile;

        try {
            allLineFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        List<String> listWords = new ArrayList<>();
        for (String line : allLineFromFile) {
            for (String word : line.toLowerCase().split(WITE_SPACE_REGEX)) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    listWords.add(word.replaceAll(NON_LETTERS_REGEX, REPLACEMENT));
                }
            }
        }

        Collections.sort(listWords);

        return listWords.toArray(new String[listWords.size()]);
    }
}

