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
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] textFile = builder.toString().toLowerCase().split("\\W+");
        builder.delete(0, builder.length());
        for (String s : textFile) {
            if (s.startsWith("w")) {
                builder.append(s).append(" ");
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
