package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String[] DEFAULT_STRING = {};

    public String[] readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        StringBuilder builder = new StringBuilder();
        String fileContent;
        int counter = 0;

        try {
            fileContent = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] sortedArray = fileContent.toLowerCase().split("\\W+");
        Arrays.sort(sortedArray);

        for (String string : sortedArray) {
            if (string.startsWith("w")) {
                builder.append(string).append(" ");
                counter++;
            }
        }

        if (counter > 0) {
            return builder.toString().split(" ");
        }
        return DEFAULT_STRING;
    }
}
