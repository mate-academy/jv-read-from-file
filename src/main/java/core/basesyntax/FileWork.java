package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            if (value == -1) {
                return new String[]{};
            }
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String hello = builder.toString();
        String[] first = hello.split(" ");
        for (int i = 0; i < first.length; i++) {
            if (first[i].startsWith("W") || first[i].startsWith("w")) {
                builder1.append(first[i].toLowerCase());
                builder1.append(" ");
            }
        }
        if (builder1.isEmpty()) {
            return new String[]{};
        }
        String[] finish = builder1.toString().split(("\\W+"));
        Arrays.sort(finish);
        return finish;
    }
}
