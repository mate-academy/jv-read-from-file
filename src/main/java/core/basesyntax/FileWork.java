package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            StringBuilder result = new StringBuilder();
            String string = new String(Files.readAllBytes(file.toPath()));
            String[] array = string.replaceAll("[^a-zA-Z ]", "")
                    .replaceAll("\n", " ")
                    .toLowerCase().split(" ");
            for (String word : array) {
                if (word.startsWith("w")) {
                    result.append(word).append(" ");
                }
            }
            String[] arrayResult = result.toString().split(" ");
            Arrays.sort(arrayResult);
            return arrayResult;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
