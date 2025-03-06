package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line.toLowerCase()).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read", e);
        }
        String file = stringBuilder.toString();
        String[] words = file.split("\\s+");
        int count = 0;
        for (String string : words) {
            if (!string.isEmpty() && string.charAt(0) == 'w') {
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }
        String[] result = new String[count];
        int index = 0;
        for (String string : words) {
            if (!string.isEmpty() && string.charAt(0) == 'w') {
                string = string.replaceAll("[^a-zA-Z]+$", "");
                result[index] = string;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
