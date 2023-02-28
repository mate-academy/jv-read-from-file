package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        try {
            String fileString = new String(Files.readAllBytes(file.toPath()));
            String[] array = fileString.split(" ");
            StringBuilder sortedString = new StringBuilder();
            for (String str : array) {
                if (str.toLowerCase().replaceAll("\\W", "").startsWith("w")) {
                    sortedString.append(str.toLowerCase().replaceAll("\\W", "")).append(System.lineSeparator());
                }
            }
            String[] requiredArray = sortedString.toString().split(System.lineSeparator());
            Arrays.sort(requiredArray);
            return requiredArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
