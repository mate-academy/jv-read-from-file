package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX = "\\p{Punct}";

    public String[] readFromFile(String fileName) {
        //write your code here
        List<String> text;
        File file = new File(fileName);
        List<String> specialWords = new ArrayList<>();
        try {
            text = Files.readAllLines(Path.of(file.toURI()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        for (String rowFromText : text) {
            rowFromText = rowFromText.replaceAll(REGEX, "");
            String[] splitString = rowFromText.toLowerCase().split(" ");
            for (String word : splitString) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    specialWords.add(word);
                }
            }
        }
        Collections.sort(specialWords);
        return specialWords.toArray(new String[0]);
    }
}
