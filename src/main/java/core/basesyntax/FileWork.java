package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder bufResult = new StringBuilder();
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
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

        } catch (IOException e) {
            throw new RuntimeException("Can not read this file",e);
        }

        Arrays.sort(result);
        if (bufResult.toString().length() == 0) {
            return new String[0];
        }
        return result;
    }
}
