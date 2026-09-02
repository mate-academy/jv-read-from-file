package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        int resultLength = 0;
        int j = 0;
        String[] result;
        String[] res = new String[]{};
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();

            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }

            String finito = builder.toString().toLowerCase();
            res = finito.split("[\\W_]+");

            for (int i = 0; i < res.length; i++) {
                if (res[i].startsWith("w")) {
                    resultLength++;
                }
            }

            result = new String[resultLength];

            for (int i = 0; i < res.length; i++) {
                if (res[i].startsWith("w")) {
                    result[j] = res[i];
                    j++;
                }
            }

            Arrays.sort(result);

        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file.", e);
        }

        return result;
    }
}
