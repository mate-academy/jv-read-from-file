package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final char patternOfCharW = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                String valueToLowerCase = value.toLowerCase();
                String[] words = valueToLowerCase.split("\\W+");

                for (int i = 0; i < words.length; i++) {
                    if (words[i].charAt(0) == patternOfCharW) {
                        builder.append(words[i]).append(" ");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (builder.isEmpty()) {
            return new String[0];
        }

        String[] parts = builder.toString().trim().split(" ");
        Arrays.sort(parts);
        return parts;
    }
}
