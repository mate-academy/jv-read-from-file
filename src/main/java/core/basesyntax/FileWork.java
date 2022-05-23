package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        String[] words = builder.toString().split("[^a-zA-Z]+");
        StringBuilder wordsWithW = new StringBuilder();
        boolean isNotW = true;
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches("^[wW].*")) {
                wordsWithW.append(words[i]).append(" ");
                isNotW = false;
            }
        }
        if (isNotW) {
            return new String[0];
        }
        String[] sortWords = wordsWithW.toString().toLowerCase().trim().split(" ");
        Arrays.sort(sortWords);
        return sortWords;

    }
}
