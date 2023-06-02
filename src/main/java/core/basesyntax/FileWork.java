package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final int ZERO_INDEX = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder localResult = new StringBuilder();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String text = String.join(System.lineSeparator(), strings);
            if (text.isEmpty()) {
                return new String[ZERO_INDEX];
            }
            String[] words = text.toLowerCase().split("\\W+");
            for (String word : words) {
                int index = word.indexOf('w');
                if (index == ZERO_INDEX) {
                    localResult
                            .append(word)
                            .append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] result = localResult.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
