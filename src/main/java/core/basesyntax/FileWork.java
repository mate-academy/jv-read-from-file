package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String regexpForDividingWords = "\\\\W+";

    public String[] readFromFile(String fileName) {
        //write your code here
        Path path = Paths.get(fileName);
        try {
            List<String> readSentences = Files.readAllLines(path);
            List<String> wordsStartsWithW = new ArrayList<>();
            for (String sentence : readSentences) {
                wordsStartsWithW.addAll(getWordsThatStartsWithW(sentence));
            }
            Collections.sort(wordsStartsWithW);
            return wordsStartsWithW.toArray(new String[0]); // Return array, not list
        } catch (IOException e) {
            throw new RuntimeException("Error while reading all bytes", e);
        }
    }

    private List<String> getWordsThatStartsWithW(String sentence) {
        String[] words = sentence.split(regexpForDividingWords);
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (checkIfStartsW(word))
                filteredWords.add(word.toLowerCase());
        }
        return filteredWords;
    }

    private boolean checkIfStartsW(String word) {
        return word.charAt(0) == 'w' || word.charAt(0) == 'W';
    }
}
