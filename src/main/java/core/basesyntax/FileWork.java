package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String stringLine = bufferedReader.readLine();
            while (stringLine != null) {
                String[] words = stringLine.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                stringLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        String[] wordsStartsWith = stringBuilder.length() == 0 ? new String[0]
                : stringBuilder.toString().split(" ");
        Arrays.sort(wordsStartsWith);
        return wordsStartsWith;
    }
}
