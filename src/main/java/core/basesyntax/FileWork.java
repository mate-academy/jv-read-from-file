package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] newArr = new String[0];
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();

            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                value = reader.readLine();
            }
            String str = stringBuilder.toString();
            String[] split = str.split("\\W+");
            Arrays.sort(split);
            int count = 0;
            for (int i = 0; i < split.length; i++) {
                if (!split[i].isEmpty() && split[i].substring(0, 1).equals("w")) {
                    count++;
                }
            }
            if (count == 0) {
                return new String[0];
            }
            int j = 0;
            newArr = new String[count];
            for (int i = 0; i < split.length; i++) {
                if (split[i].substring(0, 1).equals("w")) {
                    newArr[j] = split[i];
                    j++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t read file", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
        return newArr;
    }
}
