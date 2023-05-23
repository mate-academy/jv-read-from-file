package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public static String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            if (line == null) {
                return new String[0];
            }
            while (line != null) {
                String[] lineResult = line.toLowerCase().split("\\W+");
                for (String result : lineResult) {
                    if (result.startsWith("w")) {
                        builder.append(result).append(" ");
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String[] array = builder.toString().trim().split(" ");
        Arrays.sort(array);
        System.out.println(array.length);
        return array;
    }
}
