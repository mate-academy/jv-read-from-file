package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = new String[0];
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            int value = buffer.read();
            while (value != -1) {
                if ((char)value == 'W' || (char)value == 'w') {
                    while (value >= 65 && value <= 90 || value >= 97 && value <= 122) {
                        stringBuilder.append((char)value);
                        value = buffer.read();
                    }
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = stringBuilder.toString().toLowerCase(Locale.ROOT);
                    stringBuilder.setLength(0);
                }
                else if (value >= 65 && value <= 90 || value >= 97 && value <= 122) {
                    while (value >= 65 && value <= 90 || value >= 97 && value <= 122) {
                        value = buffer.read();
                    }
                } else {
                    value = buffer.read();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
        Arrays.sort(arr);
        return arr;
    }
}
