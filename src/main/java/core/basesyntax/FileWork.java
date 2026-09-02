package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder sortedBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();

            if (value == null) {
                return new String[0];
            }

            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Such file doesn't exist" + e);
        }

        String[] sortedArray = builder.toString().split("\\W+");

        for (String part : sortedArray) {
            part = part.toLowerCase();
            if (part.charAt(0) == 'w') {
                sortedBuilder.append(part).append(" ");
            }
        }

        if (sortedBuilder.isEmpty()) {
            return new String[0];
        }

        String[] outputArray = sortedBuilder.toString().split("\\W+");

        Arrays.sort(outputArray);
        return outputArray;
    }
}
