package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] value;

        try {
            value = String.valueOf(Files.readAllLines(file.toPath())).split("\\W+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String v : value) {
            v = v.toLowerCase();
            if (v.startsWith(SPECIFIED_CHARACTER)) {
                stringBuilder.append(v).append(" ");
            }
        }
        String result = stringBuilder.toString();
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] array = result.split(" ");
        Arrays.sort(array);
        return array;
    }
}
