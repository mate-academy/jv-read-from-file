package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder dataFromFile = new StringBuilder();
        String[] resultStrArr = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            if (!bufferedReader.ready()) {
                return resultStrArr;
            }
            String line = bufferedReader.readLine();
            while (line != null) {
                dataFromFile.append(line).append(" ");
                line = bufferedReader.readLine();
            }
            resultStrArr = convertTextToStringArray(dataFromFile);
            Arrays.sort(resultStrArr);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return resultStrArr;
    }

    public String[] convertTextToStringArray(StringBuilder text) {
        String[] resultStringArray = text.toString().split(" ");
        StringBuilder collectedWWords = new StringBuilder();
        for (String s : resultStringArray) {
            // Remove non-alphabetic characters
            String word = s.replaceAll("[^a-zA-Z]+", "");
            if (!word.isEmpty() && Character.toLowerCase(word.charAt(0))
                    == SPECIFIED_CHARACTER) {
                collectedWWords.append(word).append(" ");
            }
        }
        if (collectedWWords.length() > 0) {
            resultStringArray = collectedWWords.toString().toLowerCase().split(" ");
        } else {
            resultStringArray = new String[0];
        }
        return resultStringArray;
    }
}
