package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Error while reading file" + e);
        }
        String text = stringBuilder.toString().toLowerCase();

        int i = 0;
        String[] split = text.split("\\W+");
        for (String splitRow : split) {
            if (splitRow.charAt(0) == 'w') {
                i++;
            }
        }

        String[] result = new String[i];
        i = 0;
        for (String splitRow : split) {
            if (splitRow.charAt(0) == 'w') {
                result[i] = splitRow;
                i++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
