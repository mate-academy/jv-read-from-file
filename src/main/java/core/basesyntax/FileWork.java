package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file ", e);
        }
        if (lines.size() == 0) {
            return new String[]{};
        }
        String[] linesToArray = lines.toString()
                .toLowerCase()
                .split("\\W+");
        for (String word : linesToArray) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                stringBuilder.append(word).append(" ");
            }
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
