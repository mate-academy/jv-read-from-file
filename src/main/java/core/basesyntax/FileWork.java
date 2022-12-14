package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String temp;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if (reader.toString().equals("") || reader.toString().length() == 0) {
                return new String[0];
            }
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(",");
                value = reader.readLine();
            }
            temp = builder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] arr = temp.split("\\W+");
        Arrays.sort(arr);
        StringBuilder secondBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) == 'w') {
                secondBuilder.append(arr[i]).append(" ");
            }
        }
        String[] result = secondBuilder.toString().split(" ");
        return result;
    }
}
