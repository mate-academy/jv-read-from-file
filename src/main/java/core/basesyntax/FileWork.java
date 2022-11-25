package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
        String[] s = new String[0];
        if (stringBuilder.toString().length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].substring(0, 1).equals("w")) {
                builder.append(split[i]).append(" ");
            }
        }
        String[] split2 = builder.toString().split(" ");
        Arrays.sort(split2);
        if (builder.toString().length() == 0) {
            return s;
        }
        return split2;
    }
}
