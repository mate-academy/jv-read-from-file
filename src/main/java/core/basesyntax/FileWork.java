package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String stringOfWords = bufferedReader.readLine();
            while (stringOfWords != null) {
                String[] stringOfCleanedWords = stringOfWords.toLowerCase()
                        .split("[\\s\\p{Punct}]+");
                for (String word : stringOfCleanedWords) {
                    if (word.startsWith("w")) {
                        stringBuilder.append(word).append(' ');
                    }
                }
                stringOfWords = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a data from file",e);
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[0];
        }
        String[] resultString = stringBuilder.toString().split(" ");
        Arrays.sort(resultString);
        return resultString;
    }
}
