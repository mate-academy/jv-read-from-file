package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                builder.append((char)value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
        String[] fileWords = builder.toString().toLowerCase().split("\\W+");
        builder.setLength(0);
        for (String words : fileWords) {
            if (words.charAt(0) == 'w') {
                builder.append(words).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] file = builder.toString().split(" ");
        Arrays.sort(file);
        return file;
    }
}
