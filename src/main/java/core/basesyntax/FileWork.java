package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder array = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            do {
                array.append(line).append(" ");
                line = bufferedReader.readLine();
            } while (line != null);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String sentence = array.toString();
        String[] words = sentence.toLowerCase().split("\\W+");
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("w")) {
                index++;
            }
        }
        String[] result = new String[index];
        index = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("w")) {
                result[index] = words[i].toLowerCase();
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
