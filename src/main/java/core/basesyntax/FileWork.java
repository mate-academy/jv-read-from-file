package core.basesyntax;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String FILTER_PATTERN = "\\b[^w]*.*?\\b";
    private static final String SPLITERATOR = "\\W+";

    public String[] readFromFile(String fileName) {
        String[] data;
        try {
            data = Files.readString(Path.of(fileName))
                     .toLowerCase(Locale.ROOT)
                     .replaceAll(FILTER_PATTERN, " ")
                     .strip()
                     .split(SPLITERATOR);

        } catch (Exception e) {
            throw new RuntimeException("Can`t read file with name: " + fileName, e);
        }

        if (data.length <= 1) {
            return new String[]{};
        }

        Arrays.sort(data);
        return data;
    }
}
