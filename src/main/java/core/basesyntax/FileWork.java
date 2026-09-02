package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            String textOfFile = String.valueOf(Files.readAllLines(file.toPath()));
            String[] wordsOfFile = textOfFile.trim().split("\\W+");
            String[] result = startsWithW(wordsOfFile);
            Arrays.sort(result);
            return (result.length == 1 && result[0] == "") ? new String[0] : result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public String[] startsWithW(String[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : data) {
            if (word.startsWith("W") || word.startsWith("w")) {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        String[] result = stringBuilder.toString().split(" ");
        return result;
    }
}
