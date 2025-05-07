package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String[] wordsWithW = new String[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int value = bufferedReader.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String[] words = stringBuilder.toString().split("\\W+");
            int numberOfWordsWithW = 0;
            for (String word : words) {
                if (!word.equals("") && (word.charAt(0) == 'w' || word.charAt(0) == 'W')) {
                    numberOfWordsWithW++;
                }
            }
            wordsWithW = new String[numberOfWordsWithW];
            numberOfWordsWithW = 0;
            for (String word : words) {
                if (!word.equals("") && (word.charAt(0) == 'w' || word.charAt(0) == 'W')) {
                    wordsWithW[numberOfWordsWithW++] = word.toLowerCase();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file", e);
        } finally {
            if (wordsWithW.length > 0) {
                Arrays.sort(wordsWithW);
            }
        }
        return wordsWithW;
    }
}
