package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String words;
            while ((words = reader.readLine()) != null) {
                String[] array = words.split("\\W");
                for (String string : array) {
                    if (string.matches("^[w|W][a-zA-Z]+")) {
                        stringBuilder.append(string + " ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] array;
        if (!stringBuilder.isEmpty()) {
            array = stringBuilder.toString().toLowerCase(Locale.ROOT).split(" ");
            Arrays.sort(array);
            return array;
        }
        return new String[0];
    }
}
