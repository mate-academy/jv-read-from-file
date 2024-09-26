package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        StringBuilder result = new StringBuilder();
        Path path = Path.of(fileName);
        try {
            String content = Files.readString(path);
            String[] words = content.toLowerCase().split("[\\s\\p{Punct}]+");

            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(SPECIFIED_CHARACTER)) {
                    result.append(words[i]).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (result.isEmpty()) {
            return new String[0];
        }

        String[] resultArray = result.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;

    }
}
