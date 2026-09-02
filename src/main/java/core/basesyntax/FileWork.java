package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] wordsLine = value.toLowerCase().split("\\W+");
                for (String word : wordsLine) {
                    if (word.charAt(0) == SPECIFIED_CHARACTER) {
                        words.add(word);
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        Collections.sort(words);

        return words.stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }
}
