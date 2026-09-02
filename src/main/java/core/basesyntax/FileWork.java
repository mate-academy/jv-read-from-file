package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String LETTER = "w";
    private static final String SEPARATOR = " ";
    private static final String DELETED_SYMBOL = "(?u)[^\\pL ]";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String stringFromFile = Files.readString(Path.of(fileName));
            String allString = stringFromFile.replaceAll(DELETED_SYMBOL, SEPARATOR);
            String[] allStringArray = allString.toLowerCase().split(" ");
            for (String stringFile : allStringArray) {
                if (stringFile.startsWith(LETTER)) {
                    stringBuilder.append(stringFile).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String [] resultArray = stringBuilder.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}

