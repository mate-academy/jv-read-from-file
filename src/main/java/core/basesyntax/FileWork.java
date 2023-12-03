package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        Path filePath = Path.of(fileName);
        String content;
        try {
            content = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        content = content.replaceAll("\n", " ");
        String[] str = content.toLowerCase().split(" ");

        int couter = 0;
        for (String i : str) {
            if (i.startsWith("w")) {
                couter++;
            }
        }

        String[] result = new String[couter];

        for (String i : str) {
            if (i.startsWith("w") && couter >= 0) {
                result[couter - 1] = i.replaceAll("[^a-z]", "");
                couter--;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
