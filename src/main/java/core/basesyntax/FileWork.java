package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPACE = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                value = value.replaceAll("[!?,.]", " ");
                value = value.replace("W", "w");
                String[] words = value.split(SPACE);
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
            String resultString = stringBuilder.toString().trim();
            if (resultString.length() == 0) {
                return new String[0];
            }
            String[] resultArray = resultString.split(SPACE);
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("We can't read data from file", e);
        }
    }
}
