package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file " + fileName, e);
        }
        String[] buffer = stringBuilder.toString().split("\\W+");
        Arrays.sort(buffer);
        stringBuilder = new StringBuilder();
        for (String el : buffer) {
            if (el.startsWith("w")) {
                stringBuilder.append(el).append(" ");
            }
        }
        return stringBuilder.length() == 0
                ? new String[]{}
                : stringBuilder.toString().split(" ");
    }
}
