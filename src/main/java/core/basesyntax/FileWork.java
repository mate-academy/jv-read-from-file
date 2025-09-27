package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                sb.append(line).append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        if (sb.length() == 0) {
            return new String[0];
        }
        String[] words = sb.toString().split("[\\s\\p{Punct}]+");
        int count = 0;
        for (String word : words) {
            if (word.toLowerCase().charAt(0) == 'w') {
                count++;
            }
        }
        String[] result = new String[count];
        for (String word : words) {
            if (word.toLowerCase().charAt(0) == 'w') {
                result[result.length - count] = word.toLowerCase();
                count--;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
