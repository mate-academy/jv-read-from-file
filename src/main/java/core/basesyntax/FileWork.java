package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsList = new ArrayList<>();
        String regex = "[\\W\\s]+";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split(regex);
                for (String word : words) {
                    if (word.startsWith("w")) {
                        wordsList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: ", e);
        }

        String[] result = wordsList.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
