package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            StringBuilder tempData = new StringBuilder();
            while (value != -1) {
                tempData.append((char) value);
                value = bufferedReader.read();
            }
            String[] splitedData = tempData.toString().split("\\W+");
            tempData.setLength(0);
            for (String word : splitedData) {
                String lowerCaseWord = word.toLowerCase();
                if (lowerCaseWord.startsWith("w")) {
                    tempData.append(lowerCaseWord).append(" ");
                }
            }
            if (tempData.isEmpty()) {
                return new String[0];
            }
            String[] result = tempData.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
