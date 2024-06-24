package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] wordsArray = stringBuilder.toString().split("\\W+");
            String[] resultWordsArray = new String[wordsArray.length];
            int index = 0;
            for (String word : wordsArray) {
                if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                    resultWordsArray[index] = word.toLowerCase();
                    index++;
                }
            }
            String[] result = Arrays.copyOf(resultWordsArray, index);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
