package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] result;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder allFile = new StringBuilder();
            String value = reader.readLine();
            if (value == null || value.isEmpty()) {
                return new String[0];
            }
            while (value != null) {
                if (!value.isEmpty()) {
                    allFile.append(value);
                    allFile.append(" ");
                }
                value = reader.readLine();
            }
            String[] strArray = allFile.toString().toLowerCase().split(" ");
            ArrayList<String> stringArrayList = new ArrayList<>();
            for (int i = 0; i < strArray.length; i++) {
                if (strArray[i].charAt(0) == 'w') {
                    strArray[i] = strArray[i].replaceAll("[.!?]", "");
                    stringArrayList.add(strArray[i]);
                }
            }
            result = stringArrayList.toArray(new String[0]);
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return result;
    }
}
