package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR = " ";
    private static final String SYMBOL = "W";

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        String[] words;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder result = new StringBuilder();
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                String[] currentLine = lineFromFile.split(SEPARATOR);
                for (String word : currentLine) {
                    if (word.toUpperCase().startsWith(SYMBOL)) {
                        word = word.replaceAll("[^A-Za-z\\s]", "");
                        result.append(word.toLowerCase())
                                .append(SEPARATOR);
                    }
                }
                lineFromFile = bufferedReader.readLine();
            }
            words = result.toString().split(SEPARATOR);
            if (result.isEmpty()) {
                return new String[]{};
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find file " + e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t find the line " + e);
        }
        Arrays.sort(words);
        return words;
    }
}
