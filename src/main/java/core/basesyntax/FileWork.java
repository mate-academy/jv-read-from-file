package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPLIT_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        try {
            String readString = Files.readString(Path.of(fileName));
            for (String string : readString.split(SPLIT_REGEX)) {
                if (string.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    stringList.add(string.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }
        String[] filteredWordArray = stringList.toArray(new String[0]);
        Arrays.sort(filteredWordArray);
        return filteredWordArray;
    }
}
