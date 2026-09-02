package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder words = new StringBuilder();
        try {
            String values = Files.readAllLines(file.toPath()).toString();
            if (values != null) {
                for (String value : values.toLowerCase().split("\\W+")) {
                    if (value.startsWith(SPECIFIED_CHARACTER)) {
                        words.append(value).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (words.isEmpty()) {
            return new String[0];
        }
        String[] result = words.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
