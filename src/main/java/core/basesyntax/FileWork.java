package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
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
        return removeCharacters(result);
    }

    private StringBuilder findWords(String line) {
        StringBuilder result = new StringBuilder();
        for (String word: (line.toLowerCase()).split(" ")) {
            if (word.charAt(0) == 'w') {
                result.append(word).append(" ");
            }
        }
        return result;
    }

    private String[] removeCharacters(String[] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = buffer[i].replaceAll("[^a-zA-Z]", "");
        }
        return buffer;
    }
}
