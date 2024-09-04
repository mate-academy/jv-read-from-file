package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        if (stringBuilder.isEmpty()) {
            return new String[0];
        }
        String[] words = stringBuilder.toString().split("\\W");
        String[] wordsStartWithW = new String[words.length];

        int cursorIndex = 0;
        for (String word : words) {
            word = word.toLowerCase();
            if (word.startsWith("w")) {
                wordsStartWithW[cursorIndex] = word;
                cursorIndex++;
            }
        }
        String[] resultArray = Arrays.copyOfRange(wordsStartWithW, 0, cursorIndex);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
