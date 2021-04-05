package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_SPLITTER = "\\W+";

    public String[] readFromFile(String fileName) {
        String[] result = {};
        StringBuilder stringBuilder = new StringBuilder();
        String[] currentLineArray;
        String currentLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                currentLineArray = currentLine.toLowerCase().split(REGEX_SPLITTER);
                for (String currentString : currentLineArray) {
                    if (currentString.startsWith("w")) {
                        stringBuilder.append(currentString).append(" ");
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
