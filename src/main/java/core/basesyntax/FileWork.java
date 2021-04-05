package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String ONLY_WORDS = "\\W+";
    private static final String SPACE = " ";
    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        StringBuilder filteredWords = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split(ONLY_WORDS);
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        filteredWords.append(word).append(SPACE);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        if (filteredWords.length() > 0) {
            String[] array = filteredWords.toString().split(SPACE);
            Arrays.sort(array);
            return array;
        }
        return EMPTY_ARRAY;
    }
}
