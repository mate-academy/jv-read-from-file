package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] arrayName = stringBuilder.toString().toLowerCase().split("\\W+");
        Arrays.sort(arrayName);
        StringBuilder result = new StringBuilder();

        for (String word : arrayName) {
            if (word.charAt(0) == 'w') {
                result.append(word).append(" ");
            }
        }

        if (result.length() == 0) {
            return new String[0];
        }

        return result.toString().split(" ");
    }
}
