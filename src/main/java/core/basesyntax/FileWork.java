package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] splittedValue = value.toLowerCase().split("\\W+");
                for (String str : splittedValue) {
                    if (str.charAt(0) == 'w') {
                        builder.append(str).append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }
        String[] result;
        if (builder.toString().isEmpty()) {
            result = new String[] {};
        } else {
            result = builder.toString().split(" ");
            Arrays.sort(result);
        }
        return result;
    }
}
