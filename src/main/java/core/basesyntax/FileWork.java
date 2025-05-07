package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> strings = null;
        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (strings.isEmpty() || strings.size() == 0) {
            return new String[0];
        }
        String[] stringArray = strings.toString().replace("[", "")
                .replace("]", "").replace("!", "")
                .replace(",", "").replace(".", "")
                .replace("?", "")
                .toLowerCase().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s: stringArray) {
            if (s.indexOf("w") == 0) {
                sb.append(s);
                sb.append(",");
            }
        }
        if (sb.toString().length() == 0) {
            return new String[0];
        }
        stringArray = sb.toString().split(",");
        Arrays.sort(stringArray);
        return stringArray;
    }
}
