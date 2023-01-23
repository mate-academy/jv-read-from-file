package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] splits = builder.toString().split("\\W+");
        int counter = 0;
        String[] wrontresult = {};
        if (builder.isEmpty()) {
            return wrontresult;
        }

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].charAt(0) == 'w' || splits[i].charAt(0) == 'W') {
                stringBuilder.append(splits[i].toLowerCase()).append(" ");
            }
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));

        if (result[0].equals("")) {
            return wrontresult;
        }
        return result;
    }
}
