package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder allWords = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            if (line == null) {
                return new String[0];
            }

            while (line != null) {
                allWords.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }

        String resultWords = allWords.toString().toLowerCase();
        String[] wordToArr = resultWords.split("\\W+");

        for (String s : wordToArr) {
            if (!s.isEmpty()) {
                if (s.startsWith("w")) {
                    result.append(s).append(" ");
                }
            }
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] resultArr = result.toString().split("\\s+");
        Arrays.sort(resultArr);
        return resultArr;
    }
}
