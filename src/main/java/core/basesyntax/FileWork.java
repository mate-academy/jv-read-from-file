package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String data;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            data = stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
        data = data.replaceAll("[.,?!]", "").trim();

        if (data.isEmpty()) {
            String[] emptyArray = new String[0];
            return emptyArray;
        }

        String[] words = data.split("\\s+");
        int countOfWordsWithW = 0;
        for (String word : words) {
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                countOfWordsWithW++;
            }
        }

        String[] resultArray = new String[countOfWordsWithW];
        int i = 0;
        for (String word : words) {
            if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                resultArray[i] = word.toLowerCase();
                i++;
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
}
