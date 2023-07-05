package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }

        String[] array = stringBuilder.toString().split("\\W+");
        stringBuilder.setLength(0);
        for (String s : array) {
            if (s.startsWith("W") || s.startsWith("w")) {
                stringBuilder.append(s.toLowerCase()).append(" ");
            }
        }
        if (stringBuilder.toString().equals("")) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
