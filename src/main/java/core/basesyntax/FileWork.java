package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String[] split = stringBuilder.toString().split("\\W+");
            int index = 0;
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].toLowerCase();
                if (split[i].startsWith("w")) {
                    split[index++] = split[i];
                }
            }
            String[] result = Arrays.copyOf(split, index);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
    }
}
