package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String READ_EXCEPTION_MESSAGE = "Failed to read the file";
    private static final String SPLIT_REGEX = "\\W+";
    private static final String CONCAT_REGEX = " ";

    public String[] readFromFile(String fileName) {
        List<String> linesFromFile = readLinesFromFile(fileName);
        String concatenatedLines = concatenateList(linesFromFile);
        return getSortedArray(concatenatedLines);
    }

    private List<String> readLinesFromFile(String fileName) {
        Path path = Paths.get(fileName);
        List<String> readStringList = null;
        try {
            readStringList = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(READ_EXCEPTION_MESSAGE + e);
        }
        return readStringList;
    }

    private String concatenateList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            stringBuilder.append(CONCAT_REGEX).append(string);
        }
        return stringBuilder.toString();
    }

    private String[] getSortedArray(String inputString) {
        return Arrays.stream(inputString.split(SPLIT_REGEX))
                .map(String::toLowerCase)
                .filter(string -> string.startsWith("w"))
                .sorted()
                .toArray(String[]::new);
    }
}
