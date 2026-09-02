package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            StringBuilder stringBuilder = new StringBuilder();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append(" ");
            }

            int count = 0;
            String[] lines = stringBuilder.toString().split("\\W+");
            for (String line : lines) {
                if (!line.isBlank() && line.substring(0, 1).equalsIgnoreCase("w")) {
                    count++;
                }
            }

            String[] newArraysWords = new String[count];
            int index = 0;
            for (String line : lines) {
                if (!line.isBlank() && line.substring(0, 1).equalsIgnoreCase("w")) {
                    newArraysWords[index++] = line.toLowerCase();
                }
            }

            Arrays.sort(newArraysWords);
            return newArraysWords;

        } catch (IOException e) {
            throw new RuntimeException("Error : file not found", e);
        }
    }
}
