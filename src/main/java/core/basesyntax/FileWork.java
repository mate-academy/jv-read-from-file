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
            String linesToString = String.valueOf(connectLines).toLowerCase();
            String[] buffer = linesToString.split("\\W");
            for (String value : buffer) {
                if (value.startsWith(LETTER)) {
                    result.add(value);
                }
            }
            Collections.sort(result);
            String[] expectedArray = new String[result.size()];
            int index = 0;
            for (String value : result) {
                expectedArray[index] = value;
                index++;
            }
            return expectedArray;
            
        } catch (IOException e) {
            throw new RuntimeException(" ");
        }
    }
}
