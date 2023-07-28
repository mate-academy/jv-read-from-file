package core.basesyntax;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            String value = reader.readLine();
            while (value != null) {
                sb.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No file found: ", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: ", e);
        }
        String[] split = sb.toString().split("\\W+");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            char aimChar = 'w';
            if (split[i].toLowerCase().startsWith(String.valueOf(aimChar))) {
                split[sum] = split[i].toLowerCase();
                sum++;
            }
        }
        String[] res = Arrays.copyOf(split, sum);
        Arrays.sort(res);
        return res;
    }
}
