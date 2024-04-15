package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return new String[0];
        }
        String wholeText;
        File file = new File(fileName);
        try {
            wholeText = Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (wholeText.isBlank()) {
            return new String[0];
        }
        String[] wordsToProcess = wholeText.split("\\p{Punct}*( +|\\R+)");

        StringBuilder result = new StringBuilder();
        for (String word : wordsToProcess) {
            if (word.matches("([wW]).*")) {
                result.append(" ").append(word.toLowerCase());
            }
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        result.deleteCharAt(0);
        wordsToProcess = result.toString().split(" ");
        Arrays.sort(wordsToProcess);
        return wordsToProcess;
    }
}
