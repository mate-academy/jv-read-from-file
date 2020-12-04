package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder allText = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                allText.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            new RuntimeException("Can't find file with this name!", e);
        } catch (IOException e) {
            new RuntimeException("Error with reading a file!", e);
        }
        StringBuilder lineWordsWithCharW = new StringBuilder();
        for (String word : allText.toString().replaceAll("[!?,.]", "").toLowerCase().split(" ")) {
            if (word.startsWith(CHARACTER_W)) {
                lineWordsWithCharW.append(word).append(" ");
            }
        }
        String[] wordsWithCharW = new String[0];
        if (lineWordsWithCharW.length() != 0) {
            wordsWithCharW = lineWordsWithCharW.toString().split(" ");
            Arrays.sort(wordsWithCharW);
        }
        return wordsWithCharW;
    }
}
