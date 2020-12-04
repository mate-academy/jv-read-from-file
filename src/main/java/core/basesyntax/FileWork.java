package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIAL_LOWERCASE_W_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder allText = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                allText.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR: It seems there is no file: " + fileName, e);
        }
        return getWordsWithLowercaseW(allText);
    }

    private String[] getWordsWithLowercaseW(StringBuilder allText) {
        if (allText.length() == 0) {
            return new String[0];
        }
        String[] wordsArray = allText.toString().toLowerCase().split("[^\\w]");
        int counterForWWords = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (!wordsArray[i].isEmpty() && wordsArray[i].charAt(0) == SPECIAL_LOWERCASE_W_CHARACTER) {
                wordsArray[i] += " ";
                counterForWWords++;
            } else {
                wordsArray[i] = " ";
            }
        }
        Arrays.sort(wordsArray);
        String[] asd = new String[counterForWWords].clone();
        System.out.println(Arrays.toString(wordsArray));
        return Arrays.toString(wordsArray).split("[^\\w]").clone();
    }
}