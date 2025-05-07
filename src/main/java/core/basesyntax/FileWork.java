package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                sb.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String s = sb.toString().toLowerCase();
        String[] strings = s.split("[^A-Za-z]");
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith("w")) {
                count++;
            }
        }
        String[] arrayStr = new String[count];
        count = 0;
        for (String str : strings) {
            if (str.startsWith("w")) {
                arrayStr[count++] = str;
            }
        }
        Arrays.sort(arrayStr);
        return arrayStr;
    }
}

