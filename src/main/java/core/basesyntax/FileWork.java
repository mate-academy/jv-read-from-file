package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int arrayResultSize = 0;
        String[] resultArray;
        String[] parsedWordsArray;

        try (FileReader fileReader = new FileReader(fileName)) {
            StringBuilder parsedString = new StringBuilder();
            BufferedReader reader = new BufferedReader(fileReader);

            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            } else {
                do {
                    parsedString.append(value).append(" ");
                } while ((value = reader.readLine()) != null);
            }

            parsedWordsArray = parsedString
                    .toString()
                    .replaceAll("-", " ")
                    .replaceAll("[^a-zA-Z ]+", "")
                    .toLowerCase()
                    .split(" ");
        } catch (IOException e) {
            throw new RuntimeException("It's doesn't work, ", e);
        }

        for (String s : parsedWordsArray) {
            if (s.charAt(0) == 'w') {
                arrayResultSize++;
            }
        }

        resultArray = new String[arrayResultSize];
        for (String word : parsedWordsArray) {
            if (word.charAt(0) == 'w') {
                resultArray[--arrayResultSize] = word;
            }
        }

        Arrays.sort(resultArray);
        return resultArray;
    }
}
