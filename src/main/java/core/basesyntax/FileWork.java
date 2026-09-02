package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String fileLine = reader.readLine();
            while (fileLine != null) {
                stringBuilder.append(fileLine).append(System.lineSeparator());
                fileLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        String message = stringBuilder.toString();
        if (message.isEmpty()) {
            return new String[0];
        }
        String[] splitMessage = message.split("\\W+");
        int count = 0;
        for (String word : splitMessage) {
            if (word.substring(0, 1).equalsIgnoreCase("w")) {
                count++;
            }
        }
        String[] result = new String[count];
        count = 0;
        for (String word : splitMessage) {
            if (word.substring(0, 1).equalsIgnoreCase("w")) {
                result[count] = word.toLowerCase();
                count++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
