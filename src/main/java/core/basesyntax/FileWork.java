package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int counter = 0;
        File file = new File(fileName);
        String[] returnArray = new String[]{};

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String s = stringBuilder.toString();

            if (s.isEmpty()) {
                return returnArray;
            }
            s = s.toLowerCase();
            System.out.println("After replace: \n" + s);
            String[] strings = s.split("\\W+");

            Arrays.sort(strings);
            for (String string : strings) {
                if (string.charAt(0) == 'w') {
                    counter++;
                }
            }

            String[] result = new String[counter];
            int n = 0;
            for (String string : strings) {
                if (string.charAt(0) == 'w') {
                    result[n] = string;
                    n++;
                }
            }
            returnArray = result;

        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return returnArray;
    }
}
