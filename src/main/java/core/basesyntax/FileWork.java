package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                if ((char) value == 'w' || (char) value == 'W') {
                    while (Character.isAlphabetic((char) value)) {
                        builder.append((char) value);
                        value = bufferedReader.read();
                    }
                    builder.append(" ");
                } else {
                    while (Character.isAlphabetic((char) value)) {
                        value = bufferedReader.read();
                    }
                }
                value = bufferedReader.read();
            }
            if (builder.toString().length() == 0) {
                return new String[0];
            }
            String[] strings = builder.toString().toLowerCase(Locale.ROOT).split(" ");
            Arrays.sort(strings);
            return strings;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
