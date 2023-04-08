package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file" + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        String text = builder.toString().toLowerCase().trim();
        if (text.isEmpty()) {
            return new String[0];
        }
        String[] splitArray = text.split("\\W+");
        int count = 0;
        for (String word : splitArray) {
            if (word.startsWith("w")) {
                count++;
            }
        }
        String[] sorted = new String[count];
        int i = 0;
        for (String word : splitArray) {
            if (word.startsWith("w")) {
                sorted[i] = word;
                i++;
            }
        }
        Arrays.sort(sorted);
        return sorted;
    }
}
