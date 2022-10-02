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
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String[] split = builder.toString().toLowerCase().split("\\W+");
        String[] splitW = new String[split.length];
        int j = 0;

        for (int i = 0; i < split.length; i++) {
            splitW[i] = String.valueOf(split[i].charAt(0));
            if (splitW[i].equals("w")) {
                j++;
            }
        }
        String[] result = new String[j];
        j -= j;
        for (int i = 0; i < split.length; i++) {
            splitW[i] = String.valueOf(split[i].charAt(0));
            if (splitW[i].equals("w")) {
                result[j] = split[i];
                j++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
