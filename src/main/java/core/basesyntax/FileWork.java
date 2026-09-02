package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                String[] valueSplit = value.split("\\W+");
                for (String splitted : valueSplit) {
                    if (splitted.charAt(0) == 'W' || splitted.charAt(0) == 'w') {
                        builder.append(splitted).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + e);
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] result = builder.toString().toLowerCase().split(" ");
        Arrays.sort(result);
        return result;
    }
}

