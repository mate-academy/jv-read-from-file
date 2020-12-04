package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder allText = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                allText.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with this name!", e);
        } catch (IOException e) {
            throw new RuntimeException("Error with reading a file!", e);
        }
        return findWordsWithCharacterW(allText.toString());
    }

    private String[] findWordsWithCharacterW(String allText) {
        StringBuilder lineWordsWithCharW = new StringBuilder();
        for (String word : allText.toLowerCase().split("\\W+")) {
            if (word.startsWith(CHARACTER_W)) {
                lineWordsWithCharW.append(word).append(" ");
            }
        }
        String[] wordsWithCharW = new String[0];
        if (!lineWordsWithCharW.toString().isEmpty()) {
            wordsWithCharW = lineWordsWithCharW.toString().split(" ");
            Arrays.sort(wordsWithCharW);
        }
        return wordsWithCharW;
    }
}
