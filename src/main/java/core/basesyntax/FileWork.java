package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] words = builder.toString().split("\\W+");
        Arrays.sort(words);
        StringBuilder builder1 = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("w")) {
                builder1.append(word).append(" ");
            }
        }
        if (builder1.toString().isEmpty()) {
            return new String[0];
        }
        return builder1.toString().split(" ");
    }
}
