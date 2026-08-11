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

        String[] splitValues = builder.toString().toLowerCase().split("[^a-zA-Z]+");

        int count = 0;
        for (String word : splitValues) {
            if (word.startsWith("w")) {
                count++;
            }
        }

        String[] arrayToRead = new String[count];

        int index = 0;
        for (String word : splitValues) {
            if (word.startsWith("w")) {
                arrayToRead[index++] = word;
            }
        }

        Arrays.sort(arrayToRead);

        return arrayToRead;
    }
}



