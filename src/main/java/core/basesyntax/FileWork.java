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
    private static final String REGEX = " ";
    private static final String REGULAR_REGEX = "[^a-zA-Z]";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> list;

        try {
            list = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        List<String> listWords = new ArrayList<>();
        for (String line : list) {
            String[] allWordsInLine = line.toLowerCase().split(REGEX);

            for (String s : allWordsInLine) {
                if (startWithLetter(s)) {
                    listWords.add(s.replaceAll(REGULAR_REGEX, REPLACEMENT));
                }
            }
        }

        Collections.sort(listWords);

        return listWords.toArray(new String[listWords.size()]);
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}

