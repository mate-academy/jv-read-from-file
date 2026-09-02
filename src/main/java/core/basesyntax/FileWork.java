package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        try {
            String fileContent = Files.readString(path);
            String[] words = fileContent.toLowerCase().split("\\W+");
            StringBuilder builder = new StringBuilder();

            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    builder.append(word).append(" ");
                }
            }

            if (builder.toString().isEmpty()) {
                return new String[0];
            }

            String[] result = builder.toString().trim().split(" ");
            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
