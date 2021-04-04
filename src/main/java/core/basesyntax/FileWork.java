package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split("\\W+")) {
                    String wordToLowerCase = word.toLowerCase();
                    if (wordToLowerCase.startsWith(START_LETTER)) {
                        stringBuilder.append(wordToLowerCase).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file");
        }
        if (stringBuilder.length() > 0) {
            String[] resultWords = stringBuilder.toString().split(" ");
            Arrays.sort(resultWords);
            return resultWords;
        }
        return new String[0];
    }
}
