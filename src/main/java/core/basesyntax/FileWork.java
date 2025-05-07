package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String reader = stringBuilder.toString();
            String[] split = reader.split("\\W+");
            int length = 0;
            int index = 0;
            for (String splits : split) {
                if (splits.toCharArray()[0] == 'W' || splits.toCharArray()[0] == 'w') {
                    length++;
                }
            }
            String[] result = new String[length];
            for (int i = 0; i < split.length; i++) {
                if (split[i].toCharArray()[0] == 'W' || split[i].toCharArray()[0] == 'w') {
                    result[index] = split[i].toLowerCase();
                    index++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t do it", e);
        }

    }
}
