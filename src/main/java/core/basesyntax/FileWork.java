package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int value = br.read();
            while (value != -1) {
                sb.append((char) value);
                value = br.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Check your file", e);
        }
        if (sb.length() == 0) {
            return new String [0];
        }
        String text = sb.toString();
        String[] splits = text.split("\\W+");
        int counter = 0;
        for (String str : splits) {
            if (str.toLowerCase().charAt(0) == 'w') {
                counter++;
            }
        }
        String [] arr = new String[counter];
        counter = 0;
        for (String str : splits) {
            if (str.toLowerCase().charAt(0) == 'w') {
                arr[counter] = str.toLowerCase();
                counter++;
            }
        }
        Arrays.sort(arr);
        return arr;
    }
}
