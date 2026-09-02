package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String content;
        try {
            content = Files.readString(Path.of(fileName)); //write your code here
        } catch (IOException e) {
            return new String[0];
        }
        String lowerCaseContent = content.toLowerCase();
        String[] allWords = lowerCaseContent.split("[\\s\\p{Punct}]+");
        List<String> filteredWords = new ArrayList<>();
        for (String word : allWords) {
            if (!word.isEmpty() && word.startsWith("w")) {
                filteredWords.add(word);
            }
        }
        Collections.sort(filteredWords);
        return filteredWords.toArray(new String[0]);
    }
}
