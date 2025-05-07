package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsListW = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (word.startsWith("w")) {
                        wordsListW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file " + fileName, e);
        }

        String[] result = wordsListW.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
