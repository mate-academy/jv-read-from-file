package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sentence = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String nextString = reader.readLine();
            while (nextString != null) {
                sentence.append(nextString).append(" ");
                nextString = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File reading error", e);
        }
        return deleteExtraWords(sentence.toString().toLowerCase());
    }

    private String[] deleteExtraWords(String processedString) {
        String[] resultArray = {};
        String[] splitString = processedString.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "")
                .split(" ");
        processedString = "";
        if (splitString.length > 0) {
            StringBuilder processedStringBuilder = new StringBuilder(processedString);
            for (String checkWord : splitString) {
                if (checkWord.length() > 0 && checkWord.charAt(0) == 'w') {
                    processedStringBuilder.append(checkWord).append(" ");
                }
            }
            processedString = processedStringBuilder.toString();
            if (processedString.length() > 0) {
                resultArray = processedString.split(" ");
                Arrays.sort(resultArray);
            }
        }
        return resultArray;
    }
}
