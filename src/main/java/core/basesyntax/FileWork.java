package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            List<String> allLines = Files.readAllLines(file.toPath());
            String[] split = allLines.toString().split("\\W+");
            StringBuilder stringBuilder = new StringBuilder();
            for (String string: split) {
                if (!string.equals("")) {
                    if (string.charAt(0) == 'w' || string.charAt(0) == 'W') {
                        stringBuilder.append(string.toLowerCase()).append(" ");
                    }
                }
            }
            if (stringBuilder.toString().equals("")) {
                return new String[0];
            }
            String[] result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("reading error", e);
        }
    }
}
