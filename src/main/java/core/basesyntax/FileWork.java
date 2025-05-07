package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != -1) {
                builder.append((char)value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File is empty", e);
        }
        String dataString = builder.toString();
        String lowerDataString = dataString.toLowerCase();
        String[] dataArray = lowerDataString.split("\\W+");
        StringBuilder builderResult = new StringBuilder();
        int count = 0;
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i].startsWith("w")) {
                builderResult.append(dataArray[i]).append(" ");
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }
        String dataStr = builderResult.toString();
        String[] data = dataStr.split(" ");
        Arrays.sort(data);
        return data;
    }
}
