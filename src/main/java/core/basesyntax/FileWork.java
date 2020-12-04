package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            StringBuilder wordsReader = new StringBuilder();
            int value = reader.read();
            if (value == -1) {
                return new String[0];
            }
            int i = 0;
            int counter = 0;
            while (value != -1) {
                if ((value >= 65 && value <= 122) || (char) value == ' ') {
                    wordsReader.append((char) value);
                } else if (value == '\n') {
                    wordsReader.append(" ");
                }
                value = reader.read();
            }
            String[] arr = wordsReader.toString().toLowerCase().split(" ");
            for (i = 0; i < arr.length; i++) {
                if (arr[i].charAt(0) == 'w') {
                    counter++;
                }
            }
            String[] arrW = new String[counter];
            counter = 0;
            for (i = 0; i < arr.length; i++) {
                if (arr[i].charAt(0) == 'w') {
                    arrW[counter] = arr[i].trim();
                    counter++;
                }
            }
            Arrays.sort(arrW);
            return arrW;

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
