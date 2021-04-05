package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        List<String> strings;
        String[] result;

        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from FILE! " + fileName, e);
        }

        for (String word : strings.toString()
                                  .substring(1, strings.toString().length() - 1)
                                  .split(" ")) {
            if (strings.toString().equals("[]")) {
                return new String[0];
            }
            if (SPECIFIED_CHARACTER == word.toLowerCase().charAt(0)) {
                stringBuilder.append(word.toLowerCase().replaceAll("[\\W]", ""))
                        .append(" ");
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
