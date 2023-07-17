package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        String[] result;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            if (value == -1) {
                return new String[]{};
            }

            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
        String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
        Arrays.sort(strings);
        if (strings.length == 0) {
            return new String[]{};
        }
        StringBuilder builder = new StringBuilder();

        for (String i: strings) {
            if (i.charAt(0) == 'w') {
                builder.append(i).append(" ");
            }
        }

        if (builder.length() == 0) {
            return new String[]{};
        }
        return builder.toString().split(" ");
    }
}
