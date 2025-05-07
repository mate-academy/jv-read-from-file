package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        return filteredData(getDataFromFile(fileName));
    }

    private String getDataFromFile(String fileName) {
        StringBuilder stringBuilder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can`t read this file " + fileName, e);
        }
    }

    private String[] filteredData(String dataFromFile) {
        if (dataFromFile.equals("")) {
            return new String[] {};
        }
        String[] split = dataFromFile.toLowerCase().split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            if (s.length() > 0 && s.charAt(0) == 'w') {
                stringBuilder.append(s).append(" ");
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[]{};
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
