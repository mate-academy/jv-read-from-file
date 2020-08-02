package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            List<String> result = new ArrayList<>();
            StringBuilder connectLines = new StringBuilder();
            for (String value : lines) {
                connectLines.append(value);
            }
            for (String value : String.valueOf(connectLines).toLowerCase().split("\\W")) {
                if (value.startsWith(LETTER)) {
                    result.add(value);
                }
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(" ");
        }
    }
}
