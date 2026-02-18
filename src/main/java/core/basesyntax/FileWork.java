package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private String content;
    private StringBuilder filtered = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();

            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            content = stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (content.isEmpty()) {
            return new String[0];
        }
        String [] allWords = content.split("[^a-zA-Z]+");
        for (String word : allWords) {
            if (!word.isEmpty() && word.startsWith("w")) {
                filtered.append(word).append(" ");
            }
        }
        if (filtered.length() == 0) {
            return new String[0];
        }
        String [] result = filtered.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
