package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }

        String[] split = stringBuilder.toString().split("\\W+");

        int count = 0;
        for (String word : split) {
            if (word.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] filteredWords = new String[count];
        int index = 0;
        for (String word : split) {
            if (word.toLowerCase().startsWith("w")) {
                filteredWords[index] = word.toLowerCase();
                index++;
            }
        }

        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
