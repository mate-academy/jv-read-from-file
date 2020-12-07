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
            throw new RuntimeException("File can't be read " + fileName, e);
        }
        StringBuilder wordsOnSpecifiedChar =
                getWordsOnSpecifiedChar(information);
        if (wordsOnSpecifiedChar.length() == 0) {
            return new String[]{};
        }
        String[] wordsOnConcreteChar =
                wordsOnSpecifiedChar.toString().split(" ");
        Arrays.sort(wordsOnConcreteChar);
        return wordsOnConcreteChar;
    }

    private static boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    private static StringBuilder getWordsOnSpecifiedChar(StringBuilder information) {
        String[] words = information.toString().toLowerCase().split(DELIMITERS);
        StringBuilder wordsOnSpecifiedChar = new StringBuilder();
        for (String word : words) {
            if (startWithLetter(word)) {
                wordsOnSpecifiedChar.append(word).append(" ");
            }
        }
        return wordsOnSpecifiedChar;
    }
}
