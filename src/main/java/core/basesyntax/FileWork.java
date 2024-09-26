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
                    if (i < words.length - 1) {
                        result.append(words[i]).append(" ");
                    } else {
                        result.append(words[i]);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        if (result.length() == 0) {
            return new String[0];
        }

        String[] resultArray = result.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
