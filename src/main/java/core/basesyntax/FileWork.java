package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        File file = new File(fileName);

        if (file.length() == 0) {
            return new String[0];
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

        String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
        int num = 0;

        for (String splitLength : split) {
            if (splitLength.charAt(0) == 'w') {
                num++;
            }
        }

        if (num == 0) {
            return new String[0];
        }

        String[] result = new String[num];
        num = 0;
        for (String splitArray : split) {
            if (splitArray.charAt(0) == 'w') {
                result[num] = splitArray;
                num++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}

