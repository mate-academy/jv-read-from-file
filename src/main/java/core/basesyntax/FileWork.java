package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public static final String SEPARATOR = ",";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String fullString;
        try {
            fullString = Files.readString(file.toPath()).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("file not found", e);
        }
        String[] splitArray = fullString.split("\\W+");
        Arrays.sort(splitArray);
        StringBuilder resultBuilder = new StringBuilder("");
        for (String element : splitArray) {
            if (element.startsWith("w")) {
                resultBuilder.append(element).append(SEPARATOR);
            }
        }
        if (resultBuilder.length() == 0) {
            return new String[] {};
        }
        return resultBuilder.toString().split(SEPARATOR);
    }
}
