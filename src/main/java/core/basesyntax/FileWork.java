package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final StringBuilder builder = new StringBuilder();
    private final StringBuilder resultString = new StringBuilder();
    private final String[] emptyArray = new String[0];
    private String[] result;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != - 1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (builder.toString().length() == 0) {
            return emptyArray;
        }
        String text = builder.toString().replaceAll("[!.,?\n]", " ").toLowerCase();
        String[] splitText = text.split(" ");
        if (splitText.length == 0) {
            return emptyArray;
        }
        for (String word : splitText) {
            if (word.indexOf("w") == 0) {
                resultString.append(word).append(" ");
            }
        }
        if (resultString.toString().length() == 0) {
            return emptyArray;
        }
        result = resultString.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
