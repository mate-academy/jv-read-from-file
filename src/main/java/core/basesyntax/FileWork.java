package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                content.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] words = content.toString().split("[\\p{Punct}\\s]+");
        int count = 0;
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (lowerCaseWord.startsWith("w") && !lowerCaseWord.isEmpty()) {
                count++;
            }
        }

        String[] filteredWords = new String[count];
        int index = 0;
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (lowerCaseWord.startsWith("w") && !lowerCaseWord.isEmpty()) {
                filteredWords[index++] = lowerCaseWord;
            }
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
