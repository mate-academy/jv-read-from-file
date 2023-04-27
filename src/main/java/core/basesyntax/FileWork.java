package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private int counter = 0;
    private int index = 0;
    private final StringBuilder builder = new StringBuilder();
    private final StringBuilder resultString = new StringBuilder();
    private final String[] emptyArray = new String[0];

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
        if (builder.isEmpty()) {
            return emptyArray;
        }
        String text = builder.toString().toLowerCase();
        String[] splitText = text.split("\n");
        for (String line : splitText) {
            String[] lines = line.split(" ");
            for (String word : lines) {
                if (word.indexOf("w") == 0) {
                    resultString.append(word).append(" ");
                    counter++;
                }
            }
        }
        if (resultString.isEmpty()) {
            return emptyArray;
        }
        String[] results = new String[counter];
        String[] builder = resultString.toString().split(" ");
        for (String word : builder) {
            if (word.contains("!") || word.contains("?")) {
                word = word.substring(0, word.length() - 1);
            } else if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
            }
            results[index] = word;
            index++;
        }
        Arrays.sort(results);
        return results;
    }
}
