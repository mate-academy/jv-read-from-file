package core.basesyntax;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file");
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String[] strings = builder.toString().replaceAll(System.lineSeparator(), " ")
                .replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        builder = new StringBuilder();
        for (String string: strings) {
            if (string.charAt(0) == 'w') {
                builder.append(string)
                        .append(" ");
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        strings = builder.toString().split(" ");
        Arrays.sort(strings);
        return strings;
    }
}
