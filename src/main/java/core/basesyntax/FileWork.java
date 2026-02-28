package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String text = builder.toString().toLowerCase();

            if (text.isBlank()) {
                return new String[0];
            }

            String[] filter = text.split("\\W+");

            int count = 0;
            for (String word : filter) {
                if (word.startsWith("w")) {
                    count++;
                }
            }

            if (count == 0) {
                return new String[0];
            }

            String[] result = new String[count];
            int index = 0;

            for (String word2 : filter) {
                if (word2.startsWith("w")) {
                    result[index] = word2;
                    index++;
                }
            }
            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
