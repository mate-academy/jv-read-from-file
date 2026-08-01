package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        if (fileName == null) {
            return new String[0];
        }
        File file = new File(fileName);
        String line;
        String[] words;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty() && word.charAt(0) == 'w') {
                        stringBuilder.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringBuilder.isEmpty()) {
            return new String[0];
        }
        words = stringBuilder.toString().split("\\s+");
        Arrays.sort(words);
        return words;
    }
}
