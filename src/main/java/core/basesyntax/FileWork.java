package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CONDITION_SYMBOL = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = stringBuilder.toString().split("\\W+");
        stringBuilder.setLength(0);
        for (String word : words) {
            if (word.startsWith(CONDITION_SYMBOL)) {
                stringBuilder.append(word).append(" ");
            }
        }
        String[] sortedWords = stringBuilder.toString().split(" ");
        Arrays.sort(sortedWords);
        return stringBuilder.toString().length() == 0 ? new String[]{} : sortedWords;
    }
}
