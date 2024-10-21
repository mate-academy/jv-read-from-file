package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final String NO_PUNCTUATION_REGEX = "[^\\sa-zA-Z0-9]";
    public static final String WORDS_SEPARATOR = " ";
    public static final String READ_FROM_FILE_ERROR_MESSAGE = "Can't read from file";
    public static final String STARTING_STRING = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(READ_FROM_FILE_ERROR_MESSAGE, e);
        }

        List<String> resultList = new ArrayList<>();
        lines.forEach(line -> {
            String[] s = line
                    .toLowerCase()
                    .replaceAll(NO_PUNCTUATION_REGEX, "")
                    .split(WORDS_SEPARATOR);
            resultList.addAll(Arrays.asList(s));
        });

        return resultList.stream()
                .filter(w -> w.startsWith(STARTING_STRING))
                .sorted()
                .toArray(String[]::new);
    }
}
