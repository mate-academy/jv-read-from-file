package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String[] result;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            if (stringBuilder.toString().isEmpty()) {
                return new String[0];
            }
            String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
            stringBuilder = new StringBuilder();

            for (String string : strings) {
                if (string.indexOf(SPECIFIED_CHARACTER) == 0) {
                    stringBuilder.append(string).append(" ");
                }
            }
            result = stringBuilder.toString().trim().split(" ");
            Arrays.sort(result);
            if (result[0].indexOf(SPECIFIED_CHARACTER) != 0) {
                return new String[0];
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
