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
        String[] empty = {};
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            if (value == -1) {
                return empty;
            }
            while (value != -1) {
                if ((value >= 97 && value <= 122) || (value >= 65 && value <= 90)
                        || value == 32 || value == 45 || value == 10) {
                    if (value == 10) {
                        value = 32;
                    }
                    stringBuilder.append((char) value);
                }
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] strings = stringBuilder.toString().split(" ");
        StringBuilder filteredStrings = new StringBuilder();
        for (String string : strings) {
            if (string.startsWith("w") || string.startsWith("W")) {
                filteredStrings.append(string.toLowerCase()).append(" ");
            }
        }
        if (filteredStrings.length() == 0) {
            return empty;
        }
        String[] output = filteredStrings.toString().split(" ");
        Arrays.sort(output);
        return output;
    }
}
