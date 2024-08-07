package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char REQUESTED_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder result = new StringBuilder();
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] stringArray = line.toLowerCase().split("\\W+");
                for (String string : stringArray) {
                    if (string.charAt(0) == REQUESTED_CHAR) {
                        result.append(string).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        if (result.isEmpty()) {
            return new String[0];
        }

        String[] words = result.toString().trim().split(" ");
        Arrays.sort(words);
        return words;
    }
}
