package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Problem with file", e);
        }

        String[] wordsFromFile = stringBuilder.toString().split(" ");
        int count = 0;
        for (String word : wordsFromFile) {
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                count++;
            }
        }

        int arrayIndex = 0;
        String[] result = new String[count];
        for (String word : wordsFromFile) {
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                if (word.charAt(word.length() - 1) >= 33 && word.charAt(word.length() - 1) <= 63) {
                    result[arrayIndex] = word.substring(0, word.length() - 1).toLowerCase();
                } else {
                    result[arrayIndex] = word.toLowerCase();
                }
                arrayIndex++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
