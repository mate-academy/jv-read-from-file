package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String fileContent;
        try {
            fileContent = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            return new String[0];
        }

        List<String> wordsStartingWithW = new ArrayList<>();
        String[] allWords = fileContent.split("\\W+");
        for (String word : allWords) {
            if (!word.isEmpty()) {
                String lowerCaseWord = word.toLowerCase();
                if (lowerCaseWord.startsWith("w")) {
                    wordsStartingWithW.add(lowerCaseWord);
                }
            }
        }

        Collections.sort(wordsStartingWithW);
        return wordsStartingWithW.toArray(new String[0]);
    }
}
