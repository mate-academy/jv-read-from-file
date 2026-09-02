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
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String in = stringBuilder.toString();
        if (in.length() == 0) {
            return new String[0];
        } else {
            String[] split = in.split("\\W+");
            char[] strChar;
            String[] output;
            int count = 0;

            for (String str : split) {
                strChar = str.toCharArray();
                if (strChar[0] == 'w' || strChar[0] == 'W') {
                    count++;
                }
            }

            int i = 0;
            output = new String[count];
            for (String str : split) {
                strChar = str.toCharArray();
                if (strChar[0] == 'w' || strChar[0] == 'W') {
                    output[i] = str.toLowerCase();
                    i++;
                }
            }
            Arrays.sort(output);
            return output;
        }
    }
}

