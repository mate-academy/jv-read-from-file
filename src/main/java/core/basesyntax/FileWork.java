package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {

    static final char STARTS_WITH = 'w';

    public String[] readFromFile(String fileName) {
        String[] result;
        StringBuilder allFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            if (value == null || value.isEmpty()) {
                return new String[0];
            }
            while (value != null) {
                allFile.append(value);
                allFile.append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] strArray = allFile.toString().toLowerCase().split(" ");
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String str : strArray) {
            if (str.charAt(0) == STARTS_WITH) {
                str = str.replaceAll("[.!?]", "");
                stringArrayList.add(str);
            }
        }
        result = stringArrayList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
