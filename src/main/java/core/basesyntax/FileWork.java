package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        Path filePath = new File(fileName).toPath();
        StringBuilder builder = new StringBuilder();

        try {
            String strings = Files.readAllLines(filePath).toString();
            for (String string : strings.split("\\W+")) {

                if (string.toLowerCase().startsWith("w")) {
                    builder.append(string.toLowerCase() + " ");
                }

            }

        } catch (IOException e) {
            throw new RuntimeException("Could not read file " + fileName, e);
        }

        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        return Arrays.stream(builder.toString().split("\\W+")).sorted().toArray(String[]::new);
    }
}
