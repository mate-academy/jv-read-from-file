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
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
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
        if (secondBuilder.toString().equals("")) {
            return new String[0];
        }
        String[] result = secondBuilder.toString().split(" ");
        return result;
    }
}
