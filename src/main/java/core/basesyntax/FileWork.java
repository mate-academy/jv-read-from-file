package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    private static final String OUR_REGEX = "W";
    private static final String COMMON_REGEX = "[., -?\\n]";

    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        StringBuilder stringBuilder = new StringBuilder();
        Path path = Paths.get(fileName);
        String textFromFile;
        try {
            textFromFile = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file " + path.getFileName(), e);
        }
        String[] textArray = textFromFile.split(COMMON_REGEX);
        for (String item : textArray) {
            if ((item.length() != 0) && (item.substring(0, 1).equalsIgnoreCase(OUR_REGEX))) {
                stringBuilder.append(item.toLowerCase()).append(" ");
            }
        }
        if (stringBuilder.length() != 0) {
            result = stringBuilder.toString().split(COMMON_REGEX);
            Arrays.sort(result);
            return result;
        }
        return result;
    }
}
