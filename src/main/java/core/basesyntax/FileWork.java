package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("File is not found");;
        }

        if (text.length() == 0) {
            return new String[0];
        }

        String[] words = text.toString().toLowerCase().split("[\\p{Punct}\\s]+");
        String[] filteredWords = new String[words.length];
        int count = 0;
        for (String word : words) {
            if (word.startsWith("w")) {
                filteredWords[count++] = word;
            }
        }
        filteredWords = Arrays.copyOfRange(filteredWords, 0, count);
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
