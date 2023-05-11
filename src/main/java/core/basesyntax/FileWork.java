package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder initialString = new StringBuilder();
        StringBuilder finalString = new StringBuilder();
        final String startingCharacter = "w";
        final String splitterWord = " ";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int fileValue = reader.read();
            while (fileValue != -1) {
                initialString.append((char) fileValue);
                fileValue = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        String[] getWordsFromFile = initialString.toString().toLowerCase().split("\\W+");
        for (String word : getWordsFromFile) {
            if (word.startsWith(startingCharacter)) {
                finalString.append(word).append(splitterWord);
            }
        }
        if (initialString.toString().isEmpty() || finalString.toString().isEmpty()) {
            return new String[0];
        }
        getWordsFromFile = finalString.toString().split(splitterWord);
        Arrays.sort(getWordsFromFile);
        return getWordsFromFile;
    }
}

