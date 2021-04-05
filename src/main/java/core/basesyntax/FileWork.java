package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHECK_LETTER = "w";
    private static final String CHECK_REGEX = "[!\\.,?]";

    public String[] readFromFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().split(" ");
            for (String string : words) {
                if (string.toLowerCase().startsWith(CHECK_LETTER)) {
                    textFromFile.append(string.toLowerCase()
                            .replaceAll(CHECK_REGEX, "")).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File " + fileName + " not found", e);
        }
        if (textFromFile.length() == 0) {
            return new String[0];
        }
        String[] textArray = textFromFile.toString().split(" ");
        Arrays.sort(textArray);
        return textArray;
    }
}
