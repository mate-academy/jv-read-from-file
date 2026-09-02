package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result = new String[0];
        int calculate = 0;

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] strings = line.split("[\\s\\p{Punct}]+");
                for (String string : strings) {
                    if (string.isEmpty()) {
                        continue;
                    }
                    if (string.startsWith("W") || string.startsWith("w")) {
                        result = Arrays.copyOf(result, result.length + 1);
                        result[calculate] = string.toLowerCase(Locale.ROOT);
                        calculate++;
                    }
                }
                line = bufferedReader.readLine();
            }
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return result;
    }
}
