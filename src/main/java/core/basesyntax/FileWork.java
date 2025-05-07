package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] lines = new String[]{};
        String[] result = new String[]{};
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value == null) {
                return new String[]{};
            }

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            lines = stringBuilder.toString().toLowerCase().split("\\W+");
            Arrays.sort(lines);
            StringBuilder builder = new StringBuilder();
            for (String line : lines) {
                if (line.charAt(0) == 'w') {
                    builder.append(line).append(" ");
                }
                result = builder.toString().split(" ");
            }
            if (result.length == 1) {
                return new String[]{};

            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return result;
    }
}

