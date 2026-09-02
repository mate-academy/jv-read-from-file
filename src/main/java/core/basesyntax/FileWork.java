package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REGEX_LETTERS_ONLY = "[^\\p{L}]+";
    private final StringBuilder stringBuilder = new StringBuilder();
    private int countWord = 0;

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                findSpecifiedWord(value);
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return countWord == 0 ? new String[0] : sortedSpecifiedWord();
    }

    private String[] sortedSpecifiedWord() {
        String[] filteredFile = stringBuilder.toString().split(" ");
        Arrays.sort(filteredFile);
        return filteredFile;
    }

    private void findSpecifiedWord(String value) {
        String[] valueArray = value.toLowerCase().split(" ");
        for (String word: valueArray) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                stringBuilder.append(word.replaceAll(REGEX_LETTERS_ONLY, "")).append(" ");
                countWord++;
            }
        }
    }
}
