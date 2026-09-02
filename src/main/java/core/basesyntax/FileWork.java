package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String W_CHAR = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value);
                value = bufferedReader.readLine();

                if (value != null) {
                    builder.append(",");
                }
            }
            String[] lines = builder.toString().split(",");
            builder.setLength(0);

            for (String line: lines) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] words = line.split(" ");

                for (String word: words) {
                    String lowerPart = word.toLowerCase();

                    if (lowerPart.startsWith(W_CHAR)) {
                        builder.append(lowerPart.replaceAll("[^a-zA-Z]", "")).append(",");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
        String builderString = builder.toString();

        if (builderString.isEmpty()) {
            return new String[]{};
        }

        String[] parts = builderString.split(",");
        Arrays.sort(parts);

        return parts;

    }
}
