package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
        stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (string.charAt(0) == SPECIFIED_CHARACTER) {
                stringBuilder.append(string).append(" ");
            }
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] strings1 = stringBuilder.toString().split(" ");
        Arrays.sort(strings1);
        return strings1;
    }
}
