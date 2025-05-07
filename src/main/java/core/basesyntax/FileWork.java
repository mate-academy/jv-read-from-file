package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                stringBuilder.append(line.toLowerCase()).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String result = stringBuilder.toString()
                                     .replaceAll("\\b[^w\\s][^\\s]*\\b|[^a-z\\s]"," ")
                                     .trim();
        if (result.length() == 0) {
            return new String[0];
        }
        String[] array = result.split("\\s+");
        Arrays.sort(array);
        return array;
    }
}
