package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    private static final String WORD_SEPARATOR = "\\W+";
    private static final char TARGET_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] words = line.split(WORD_SEPARATOR);

                for (String originalWord : words) {
                    String word = originalWord.toLowerCase();

                    if (!word.isEmpty() && word.charAt(0) == TARGET_LETTER) {
                        result.add(word);
                    }
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file", e);
        }

        result.sort(String::compareTo);
        return result.toArray(new String[0]);
    }
}
