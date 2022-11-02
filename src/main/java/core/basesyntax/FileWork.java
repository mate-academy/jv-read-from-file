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
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] arrayWords = builder.toString().split("\\W");
        String[] newArray = new String[arrayWords.length];
        int count = 0;
        for (int i = 0; i < arrayWords.length; i++) {
            arrayWords[i] = arrayWords[i].toLowerCase();
            if (arrayWords[i].length() != 0 && arrayWords[i].charAt(0) == 'w') {
                newArray[count] = arrayWords[i];
                count++;
            }
        }
        String[] chooseArray = new String[count];
        for (int i = 0; i < count; i++) {
            chooseArray[i] = newArray[i];
        }
        Arrays.sort(chooseArray);
        return chooseArray;
    }
}
