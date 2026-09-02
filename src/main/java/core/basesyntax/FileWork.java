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

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    String cleanedWord = word.toLowerCase().replaceAll("\\p{Punct}", "");
                    if (cleanedWord.startsWith("w")) {
                        wordsList.add(cleanedWord);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        String[] resultArray = wordsList.toArray(new String[0]);
        Arrays.sort(resultArray);

        return resultArray;
    }
}
