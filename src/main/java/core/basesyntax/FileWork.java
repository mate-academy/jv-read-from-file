package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] wordsFromLine = line.split("\\W+");
                for (String word : wordsFromLine) {
                    if (word.toLowerCase().startsWith(String.valueOf(SPECIFIED_CHARACTER))) {
                        wordsList.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File does not exit", e);
        }
        Collections.sort(wordsList);
        return wordsList.toArray(new String[0]);
    }
}
