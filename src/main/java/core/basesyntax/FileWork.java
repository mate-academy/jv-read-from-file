package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder bufResult = new StringBuilder();
        String[] result = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new String[0];
            }
            while (line != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split(" ");
                line = bufferedReader.readLine();
                for (String word : words) {
                    if (word.startsWith("w")) {
                        bufResult.append(word).append(" ");
                    }
                }
            }
            result = bufResult.toString().split(" ");
            Arrays.sort(result);
            if (bufResult.toString().length() == 0) {
                return new String[0];
            }
            return result;
        } catch (IOException e) {
            System.out.println("Can not read this file");
        }
        return result;
    }
}
