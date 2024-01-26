package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                fileContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName + ": " + e);
        }
        String[] words = fileContent.toString().toLowerCase().split("\\W+");
        int wordsCounter = 0;
        for (String word : words) {
            if (word.startsWith(START_LETTER)) {
                wordsCounter++;
            }
        }
        String[] filteredWords = new String[wordsCounter];
        for (String word : words) {
            if (word.startsWith(START_LETTER)) {
                wordsCounter--;
                filteredWords[wordsCounter] = word;
            }
        }
        Arrays.sort(filteredWords);
        return filteredWords;
    }
}
