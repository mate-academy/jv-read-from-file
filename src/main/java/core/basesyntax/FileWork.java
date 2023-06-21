package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String CERTAIN_LETTER = "w";
    static final int STRING_INDEX = 0;
    static final int FILE_LENGTH = 0;
    static final int RESULT_LENGTH = 1;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == FILE_LENGTH) {
            return new String[STRING_INDEX];
        }
        List<String> strings;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + file.getName(), e);
        }
        String[] stringsSplit = String.valueOf(strings)
                .replaceAll("\\p{Punct}", "")
                .toLowerCase()
                .split(" ");
        StringBuilder builderOfW = new StringBuilder();
        for (String word : stringsSplit) {
            if (!word.startsWith(CERTAIN_LETTER)) {
                continue;
            }
            builderOfW.append(word).append(" ");
        }
        String[] result = String.valueOf(builderOfW).split(" ");
        Arrays.sort(result);
        if (result.length == RESULT_LENGTH) {
            return new String[STRING_INDEX];
        }
        return result;
    }
}
