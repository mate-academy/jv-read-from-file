package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File inputFile = new File(fileName);
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader incomingFileReader = new BufferedReader(new FileReader(inputFile));) {
            String currentLine;

            while ((currentLine = incomingFileReader.readLine()) != null) {
                currentLine = currentLine.replaceAll("[^a-zA-Z\\s]", "").trim();
                String[] words = currentLine.split("\\s+");

                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {
                        wordsStartingWithW.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file" + e);
        }
        String[] filteredResult = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(filteredResult);
        return filteredResult;
    }
}
