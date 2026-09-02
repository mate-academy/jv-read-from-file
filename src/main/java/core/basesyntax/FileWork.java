package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new String[0];
            }
            while (line != null) {
                String[] wordsOfLine = line.split(" ");
                for (String word : wordsOfLine) {
                    String lowerCaseWord = word.toLowerCase();
                    if (lowerCaseWord.charAt(0) == 'w') {
                        builder.append(lowerCaseWord.replaceAll("\\p{Punct}", "")).append(",");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        String result = builder.toString();
        if (result.isEmpty()) {
            return new String[0];
        }
        String[] resultArray = result.substring(0, result.lastIndexOf(',')).split(",");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
