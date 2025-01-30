package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder textContent = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textContent.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("File cannot be read", e);
        }

        String text = textContent.toString().toLowerCase();
        String[] words = text.split("\\W+");

        int count = 0;

        for (String word : words) {

            if (!word.isEmpty() && word.charAt(0) == 'w') {
                count++;
            }
        }

        if (count == 0) {
            return new String[0];
        }

        String[] filteredWords = new String[count];
        int index = 0;

        for (String word : words) {
            if (!word.isEmpty() && word.charAt(0) == 'w') {
                filteredWords[index++] = word;
            }
        }

        Arrays.sort(filteredWords); // Sorting in lexicographical order

        return filteredWords;
    }
}
