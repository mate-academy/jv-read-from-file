package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.toLowerCase().split("\\W+");

                for (String word : lineWords) {
                    if (!word.isEmpty() && word.startsWith("w")) {
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] result = words.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
