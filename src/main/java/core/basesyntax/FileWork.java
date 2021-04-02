package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result = {};

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            String[] currentLineSplit;

            while (currentLine != null) {
                currentLine = currentLine.toLowerCase();
                currentLine = currentLine.replaceAll("[^a-zA-Z]", " ");
                currentLineSplit = currentLine.split(" ");
                for (String s : currentLineSplit) {
                    if (s.startsWith("w")) {
                        stringBuilder.append(s).append(" ");
                    }
                }
                currentLine = bufferedReader.readLine();
            }
            if (stringBuilder.length() != 0) {
                result = stringBuilder.toString().split(" ");
            } else {
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        Arrays.sort(result);
        return result;
    }
}
