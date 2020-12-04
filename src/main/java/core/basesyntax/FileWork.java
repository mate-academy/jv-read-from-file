package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String DELIMITERS = "\\s*[^a-zA-Z]+\\s*";

    public String[] readFromFile(String fileName) {
        StringBuilder information = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                information.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't be read ", e);
        }
        String[] words = information.toString().toLowerCase().split(DELIMITERS);
        String[] wordsStartsOnSpecifiedCharacter =
                new String[countWordsStartsOnSpecifiedCharacter(words)];
        int index = 0;
        for (String word : words) {
            if (startWithLetter(word)) {
                wordsStartsOnSpecifiedCharacter[index] = word;
                index++;
            }
        }
        Arrays.sort(wordsStartsOnSpecifiedCharacter);
        return wordsStartsOnSpecifiedCharacter;
    }

    private static boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    private static int countWordsStartsOnSpecifiedCharacter(String[] words) {
        int counterWordsStartOnSpecifiedCharacter = 0;
        for (String word : words) {
            if (startWithLetter(word)) {
                counterWordsStartOnSpecifiedCharacter++;
            }
        }
        return counterWordsStartOnSpecifiedCharacter;
    }
}
