package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class FileWork {
    private static final String START_CHAR = "w";
    private static final String REGEX_SPLIT = "[^a-zA-Z]+";

    public String[] readFromFile(String fileName) {
        Set<String> resultWords = new TreeSet<>();
        String content;

        try {
            content = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            return new String[0];
        }

        String lowerCaseContent = content.toLowerCase();

        String[] allWords = lowerCaseContent.split(REGEX_SPLIT);

        for (String word : allWords) {
            if (!word.isEmpty() && word.startsWith(START_CHAR)) {
                resultWords.add(word);
            }
        }

        return resultWords.toArray(new String[0]);
    }

}
