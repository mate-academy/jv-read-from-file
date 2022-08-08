package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        List<String> strings;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        for (String result1 : strings) {
            String[] split = result1.toLowerCase().split(REGEX);
            for (String result2 : split) {
                if (result2.charAt(0) == SPECIFIED_CHARACTER) {
                    builder.append(result2).append(" ");
                }
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}

