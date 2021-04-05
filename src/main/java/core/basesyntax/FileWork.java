package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(findWords(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }

        if ((buffer.toString()).equals("")) {
            return new String[]{};
        }

        String[] result = (buffer.toString()).split(" ");
        Arrays.sort(result);
        return result;
    }

    private StringBuilder findWords(String line) {
        StringBuilder result = new StringBuilder();
        for (String word: line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split(" ")) {
            if (word.charAt(0) == FIRST_LETTER) {
                result.append(word).append(" ");
            }
        }
        return result;
    }
}
