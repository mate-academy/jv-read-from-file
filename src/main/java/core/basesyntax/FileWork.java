package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FILTERED_CHARACTER = "w";
    private static final String SPLITTER = "\\W+";

    public String[] readFromFile(String fileName) {
        //write your code here
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String fileContent = stringBuilder.toString();
            String[] separatedContent = fileContent.split(SPLITTER);
            int arrayLength = 0;
            for (String word: separatedContent) {
                if (word.toLowerCase().startsWith(FILTERED_CHARACTER)) {
                    arrayLength++;
                }
            }
            String[] resultArray = new String[arrayLength];
            int resultArrayIndex = 0;
            for (String word: separatedContent) {
                if (word.toLowerCase().startsWith(FILTERED_CHARACTER)) {
                    resultArray[resultArrayIndex] = word.toLowerCase();
                    resultArrayIndex++;
                }
            }
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
    }
}
