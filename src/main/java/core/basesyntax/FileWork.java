package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty() && word.charAt(0) == 'w') {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
        String [] result = new String[count];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty() && word.charAt(0) == 'w') {
                        result[index++] = word;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
        Arrays.sort(result);
        return result;
    }
}
