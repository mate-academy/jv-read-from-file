package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String line = null;
        try {
            line = Files.readAllLines(Path.of(fileName)).toString().toLowerCase()
                    .replaceAll("(,|\\.|\\?|!|]|\\[)","");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] lines = line.split(" ");
        int index = 0;

        for (String s : lines) {
            if (s.startsWith("w")) {
                index++;
            }
        }

        String[] output = new String[index];
        int ind = 0;
        for (String string : lines) {
            if (string.startsWith("w")) {
                output[ind] = string;
                ind++;
            }
        }
        Arrays.sort(output);
        return output;
    }
}
