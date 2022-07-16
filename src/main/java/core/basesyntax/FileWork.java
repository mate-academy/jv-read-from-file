package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private int length;
    private int count = 0;

    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            int value = reader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String[] strings = stringBuilder.toString().split("\\W+");
        for (String string : strings) {
            if (string.substring(0, 1).toLowerCase().equals("w")) {
                length++;
            }
        }
        String[] arrayString = new String[length];
        for (String string : strings) {
            if (string.substring(0, 1).toLowerCase().equals("w")) {
                arrayString[count] = string.toLowerCase();
                count++;
            }
        }
        Arrays.sort(arrayString);
        return arrayString;
    }
}
