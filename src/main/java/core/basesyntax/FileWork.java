package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String[] words = strings.toString().toLowerCase().split("\\W+");

            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(word).append(" ");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return stringBuilder.length() == 0 ? new String[0] : result;
    }
}
