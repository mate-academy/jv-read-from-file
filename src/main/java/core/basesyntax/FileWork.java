package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String stepOne;
        int counter = 0;
        int secondCounter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((stepOne = reader.readLine()) != null) {
                builder.append(stepOne).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String content = builder.toString();
        if (content.isEmpty()) {
            return new String[0];
        }

        String[] words = content.toLowerCase().split("\\W+");

        for (String word : words) {
            if (word.charAt(0) == 'w') {
                counter++;
            }
        }

        String[] result = new String[counter];
        for (String word : words) {
            if (word.charAt(0) == 'w') {
                result[secondCounter++] = word;
            }
        }

        Arrays.sort(result);
        return result;
    }
}
