package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_SPLITTER = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = {};
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            String[] currentLineArray;
            while (currentLine != null) {
                currentLineArray = currentLine.toLowerCase().replaceAll(REGEX_SPLITTER, " ")
                        .split(" ");
                for (String s : currentLineArray) {
                    if (s.startsWith("w")) {
                        stringBuilder.append(s).append(" ");
                    }
                }
                currentLine = bufferedReader.readLine();
            }
            if (stringBuilder.length() == 0) {
                return result;
            }
            result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return result;
    }
}
