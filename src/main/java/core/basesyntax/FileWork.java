package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class FileWork {
    private String line;
    private LinkedList<String> words = new LinkedList<>();
    private String[] splitLine;

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                splitLine = line.split("\\W+");
                for (String word : splitLine) {
                    String wordLowerCase = word.toLowerCase();
                    if (wordLowerCase.startsWith("w")) {
                        words.add(wordLowerCase);
                    }
                }
            }

        } catch (IOException exception) {
            throw new RuntimeException("I can`t to do operation!", exception);
        }
        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}
