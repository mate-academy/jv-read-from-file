package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] wordsInFile = currentLine.split("\\s+");
                for (String word : wordsInFile) {
                    String cleanedWord = word.replaceAll("^[^\\w']+|[^\\w']+$", "").toLowerCase();
                    if (cleanedWord.startsWith(SPECIFIED_CHARACTER)) {
                        wordsStartingWithW.add(cleanedWord);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file!", e);
        }

        String[] sortedArray = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(sortedArray);

        return sortedArray;
    }
}

