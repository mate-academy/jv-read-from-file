package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't red file", e);
        }
        String[] words = builder.toString().toLowerCase().split("\\W+");
        builder.setLength(0);
        for (String word: words) {
            if (word.charAt(0) == 'w') {
                builder.append(word).append(" ");
            }
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
