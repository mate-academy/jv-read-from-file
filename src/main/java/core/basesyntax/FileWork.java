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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("file not found", e);
        }
        boolean check = stringBuilder.length() == 0;
        if (check) {
            return new String[0];
        }
        String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
        int n = 0;
        for (String abc : split) {
            char[] abcChar = abc.toCharArray();
            if (abcChar[0] == 'w') {
                n++;
            }
        }
        String[] onlyW = new String[n];
        n = 0;
        for (String abc : split) {
            char[] abcChar = abc.toCharArray();
            if (abcChar[0] == 'w') {
                onlyW[n] = abc;
                n++;
            }
        }
        Arrays.sort(onlyW);
        return onlyW;
    }
}
