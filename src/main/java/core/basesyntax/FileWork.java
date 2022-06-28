package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String ALL_NON_CHARACTER = "[^a-z]+";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder getWordBuilder = new StringBuilder();
        String[] allWords = readFromFiletoString(fileName).toLowerCase().split(ALL_NON_CHARACTER);
        for (String word: allWords) {
            if (startWithLetter(word)) {
                getWordBuilder.append(word).append(" ");
            }
        }
        String[] resultStringArray = getWordBuilder.toString().trim().split(" ");
        Arrays.sort(resultStringArray);
        if (resultStringArray.length == 1) {
            return new String[0];
        }
        return resultStringArray;
    }

    public String readFromFiletoString(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder wordBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                wordBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            return wordBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("File can't read " + fileName, e);
        }
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
