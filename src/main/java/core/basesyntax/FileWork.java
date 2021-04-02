package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

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
            String words = line.toLowerCase();
            String[] allWordsInLine = words.split(" ");

            for (int i = 0; i < allWordsInLine.length; i++) {
                if (startWithLetter(allWordsInLine[i])) {
                    listWords.add(allWordsInLine[i].replaceAll("[^a-zA-Z]", ""));
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

