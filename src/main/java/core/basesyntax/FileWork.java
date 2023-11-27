package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String[] splittedData;
        int targetWordsCount = 0;
        int index = 0;
        String[] message;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();

            if (value == null) {
                return new String[0];
            }

            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }

            splittedData = builder.toString().split("\\W+");

            for (String string : splittedData) {
                if (string.toLowerCase().charAt(0) == 'w') {
                    targetWordsCount++;
                }
            }

            message = new String[targetWordsCount];

            for (String string : splittedData) {
                if (index > targetWordsCount) {
                    break;
                } else if (string.toLowerCase().charAt(0) == 'w') {
                    message[index] = string.toLowerCase();
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find such file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        Arrays.sort(message);
        return message;
    }
}
