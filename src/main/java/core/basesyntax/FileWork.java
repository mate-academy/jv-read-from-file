package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String[] emptyArray = new String[] {};

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            return emptyArray;
        }

        String[] split = builder.toString().split("\\W+");
        builder.delete(0, builder.length());
        try {
            for (String value: split) {
                if (value.charAt(0) == 'w' || value.charAt(0) == 'W') {
                    builder.append(value.toLowerCase()).append(", ");
                }
            }
            if (builder.length() == 0) {
                return emptyArray;
            }
        } catch (RuntimeException e) {
            return emptyArray;
        }
        split = builder.toString().split("\\W+");
        Arrays.sort(split);
        return split;
    }
}
