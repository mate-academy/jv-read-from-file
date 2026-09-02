package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        Path path = Paths.get(fileName);

        try {
            String content = Files.readString(path);
            String[] split = content.split("\\W+");
            String[] temp = new String[split.length];
            int counter = 0;

            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].toLowerCase();
                if (split[i].startsWith("w")) {
                    temp[counter] = split[i];
                    counter++;
                }
            }

            String[] result = new String[counter];
            for (int i = 0; i < counter; i++) {
                result[i] = temp[i];
            }

            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Reading error", e);
        }
    }
}
