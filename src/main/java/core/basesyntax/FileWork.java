package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static void main(String[] args) {
        String fileName = "file.txt";
        try {
            File file = new File(fileName);
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
        String[] result = readFromFile(fileName);
    }

    public static String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
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
            throw new RuntimeException("Can't read file" + e);
        }

        String[] words = builder.toString().toLowerCase().split(" ");
        for (String word: words) {
            int letterIndex = word.indexOf("w");
            if (word.contains("w") && letterIndex == 0) {
                String newWord = word.replaceAll("[.!?]", "");
                result.append(newWord).append(" ");
            }
        }
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] resultString = result.toString().split(" ");
        Arrays.sort(resultString);
        return resultString;
    }
}
