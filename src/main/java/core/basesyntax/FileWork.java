package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String DIVIDER = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String text = String.join(DIVIDER, strings);
            String[] spitString = text.split("\\W+");
            for (String word:spitString) {
                if (word != null && word.toLowerCase().startsWith("w")) {
                    builder.append(word.toLowerCase()).append(DIVIDER);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] result = builder.toString().isEmpty() ? new String[0]
                                  : builder.toString().split(DIVIDER);
        Arrays.sort(result);
        return result;
    }
}
