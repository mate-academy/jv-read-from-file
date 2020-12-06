package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String MY_CHARACTER = "w";
    private static final String DELIMITERS = "\\s*[^a-zA-Z]+\\s*";

    public String[] readFromFile(String fileName) {
        StringBuilder allText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                allText.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!");
        }
        String[] words = allText.toString().toLowerCase().split(DELIMITERS);
        StringBuilder myWords = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(MY_CHARACTER)) {
                myWords.append(word).append(" ");
            }
        }
        if (myWords.length() == 0) {
            return new String[]{};
        }
        String[] wordsStartedOnMyCharacter = myWords.toString().split(DELIMITERS);
        Arrays.sort(wordsStartedOnMyCharacter);
        return wordsStartedOnMyCharacter;
    }
}
