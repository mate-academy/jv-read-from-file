package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String REGEX = "[\\W]";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines;
        String[] result;

        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from FILE! " + fileName, e);
        }

        for (String line : lines) {
            if (lines.toString().equals("[]")) {
                return new String[0];
            }

            for (String word : line.toLowerCase().split(REGEX)) {
                if (word.equals("")) {
                    continue;
                }
                if (SPECIFIED_CHARACTER == word.charAt(0)) {
                    stringBuilder.append(word)
                            .append(" ");
                }
            }
        }

        result = stringBuilder.toString().trim().split(" ");
        Arrays.sort(result);
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        return result;
    }
}
