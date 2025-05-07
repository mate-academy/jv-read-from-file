package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        int count = 0;
        String[] splitValues = builder.toString().toLowerCase().split("\\W+");

        for (String word : splitValues) {
            if (word.startsWith("w")) {
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }

        String[] arrayToRead = new String[count];
        int index = 0;
        for (String word : splitValues) {
            if (word.startsWith("w")) {
                arrayToRead[index] = word;
                index++;
            }
        }
        Arrays.sort(arrayToRead);
        return arrayToRead;
    }
}
