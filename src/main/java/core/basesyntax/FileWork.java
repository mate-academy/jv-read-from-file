package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String REG_EXP = "\\W+";
    private static final String START = "w";
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] split = stringBuilder.toString().toLowerCase().split(REG_EXP);
        Arrays.sort(split);
        ArrayList<String> filter = new ArrayList<>();
        for (String str : split) {
            if (str.startsWith(START)) {
                filter.add(str);
            }
        }
        System.out.println(filter);
        return filter.toArray(new String[0]);
    }
}
