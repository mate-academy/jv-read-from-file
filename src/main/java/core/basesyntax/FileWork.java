package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            String string = new String(Files.readAllBytes(file.toPath()));

            String[] array = string.replaceAll("\n", " ").split(" ");
            StringBuilder strongWords = new StringBuilder();
            for (String word : array) {
                if (word.toLowerCase().replaceAll("\\W", "").startsWith("w")) {
                    strongWords.append(word.toLowerCase()
                                    .replaceAll("\\W", ""))
                            .append(System.lineSeparator());
                }
            }
            String[] requiredArray = strongWords.toString().split(System.lineSeparator());
            Arrays.sort(requiredArray);
            if (requiredArray[0].equals("")) {
                return new String[0];
            }
            return requiredArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
