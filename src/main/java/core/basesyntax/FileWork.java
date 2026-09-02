package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char wCharacter = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                String[] splittedString = value.split("\\W+");
                for (String splitted : splittedString) {
                    if (splitted.toLowerCase().charAt(0) == wCharacter) {
                        stringBuilder.append(splitted).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().toLowerCase().split(" ");
        Arrays.sort(result);
        return result;
    }
}
