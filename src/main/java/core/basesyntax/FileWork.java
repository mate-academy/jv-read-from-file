package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(SEPARATOR);
                value = bufferedReader.readLine();
            }
            String words = stringBuilder.toString();
            String[] strings = stringBuilder.toString().split(SEPARATOR);
            if (words.isEmpty()) {
                String[] empty = {};
                return empty;
            }
            StringBuilder result = new StringBuilder();
            for (String string : strings) {
                if (string.charAt(0) == 'w' || string.charAt(0) == 'W') {
                    string = string.replaceAll("[^a-zA-Z]", "");
                    string = string.toLowerCase();
                    result.append(string).append(SEPARATOR);
                }
            }
            String[] newResult = result.toString().split(SEPARATOR);
            Arrays.sort(newResult);
            return newResult;
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file", e);
        }
    }
}
