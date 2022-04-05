package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String[] emptyArray = new String[] {};

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            return emptyArray;
        }

        String[] split = stringBuilder.toString().split("\\W+");
        stringBuilder.delete(0, stringBuilder.length());
        try {
            int i = 0;
            for (String value : split) {
                if (value.charAt(0) == 'w' || value.charAt(0) == 'W') {
                    stringBuilder.append(value.toLowerCase()).append(", ");
                    i++;
                }
            }
            if (i == 0) {
                return emptyArray;
            }
        } catch (RuntimeException e) {
            return emptyArray;
        }
        split = stringBuilder.toString().split("\\W+");
        Arrays.sort(split);
        return split;
    }
}
