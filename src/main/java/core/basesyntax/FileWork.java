package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //Read data from file
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }

        String[] words = stringBuilder.toString().replaceAll("\\p{Punct}", "").toLowerCase().trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty() && word.charAt(0) == 'w') {
                result.append(word).append(" ");
            }
        }
        if (result.length() == 0) {
            return new String[0];
        }
        String[] filteredWords = result.toString().split("\\s+");
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
