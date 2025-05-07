package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String START_WITH_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File(fileName)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] resultArray = filterWordsStartWith(stringBuilder.toString().toLowerCase()
                .split("[^a-zA-z/d]"), START_WITH_LETTER);
        Arrays.sort(resultArray);
        return resultArray;
    }

    private String[] filterWordsStartWith(String[] words, String startWithLetter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.startsWith(startWithLetter)) {
                stringBuilder.append(word).append(" ");
            }
        }
        return stringBuilder.length() != 0 ? stringBuilder.toString().split(" ") : new String[0];
    }
}
