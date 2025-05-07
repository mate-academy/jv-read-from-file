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
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] split = value.split("\\W+");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].charAt(0) == 'w' || split[i].charAt(0) == 'W') {
                        builder.append(split[i]).append(",");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] split = builder.toString().toLowerCase().split(",");
        Arrays.parallelSort(split);
        return split;
    }
}
