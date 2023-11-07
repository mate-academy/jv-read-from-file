package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String[] resultArray;
            String value;
            while ((value = reader.readLine()) != null) {
                String[] split = value.split("\\W+");
                for (String string : split) {
                    if (string.toLowerCase().startsWith("w")) {
                        stringBuilder.append(string.toLowerCase() + ",");
                    }
                }
            }
            resultArray = stringBuilder.toString().split(",");
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
