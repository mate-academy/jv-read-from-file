package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int counter = 0;
        int index = 0;
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String value = null;

            while ((value = file.readLine()) != null) {
                String[] arrayLines = value.toLowerCase().split(" ");
                for (String word : arrayLines) {
                    if (word.startsWith("w")) {
                        counter++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = new String[counter];
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            String value = null;

            while ((value = file.readLine()) != null) {
                String[] arrayLines = value.toLowerCase().split("\\W+");

                for (String word : arrayLines) {
                    if (word.startsWith("w")) {
                        result[index] = word.toLowerCase();
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Arrays.sort(result);
        return result;
    }
}
