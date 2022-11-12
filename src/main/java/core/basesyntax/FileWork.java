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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Something was wrong. ", e);
        }
        String[] split = builder.toString().split("\\W+");
        String[] array = new String[split.length];
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].toLowerCase();
            if (split[i].length() != 0 && split[i].charAt(0) == 'w') {
                array[count] = split[i];
                count++;
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        Arrays.sort(result);
        return result;
    }
}
