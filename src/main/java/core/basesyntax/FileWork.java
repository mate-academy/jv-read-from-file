package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        if (fileName.isEmpty() || fileName == "") {
            return new String[0];
        }

        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        String value;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
        stringBuilder.setLength(0);
        for (String str : strings) {
            if (str.charAt(0) == 'w') {
                stringBuilder.append(str).append(System.lineSeparator());
            }
        }
        if (stringBuilder.length() > 0) {
            String[] result = stringBuilder.toString().split(System.lineSeparator());
            Arrays.sort(result);
            return result;
        }
        return new String[0];
    }
}
