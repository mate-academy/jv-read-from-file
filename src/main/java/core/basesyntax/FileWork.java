package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            String string = new String(Files.readAllBytes(file.toPath()));
            StringBuilder stringWords = new StringBuilder();

            String[] array = string.replaceAll("\n", " ")
                    .replaceAll("\\W", "")
                    .toLowerCase()
                    .split(" ");
            for (String word : array) {
                if (word.startsWith("w")) {
                    stringWords.append(word).append(System.lineSeparator());
                }
            }
            String[] arrayResult = stringWords.toString().split(System.lineSeparator());
            Arrays.sort(arrayResult);
            if (arrayResult[0].equals("")) {
                return new String[0];
            }
            return arrayResult;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
