package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_WORD = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here

        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String result = builder.toString().toLowerCase();
        String[] dividedString = result.split("\\W+");
        if (dividedString[0].isEmpty()) {
            return new String[0];
        }
        int numbersOfWords = 0;
        for (int i = 0; i < dividedString.length; i++) {
            if (dividedString[i].charAt(0) == FIRST_WORD) {
                numbersOfWords++;
            }
        }

        int counter = 0;
        String[] wordsFilteredArray = new String[numbersOfWords];
        for (String word : dividedString) {
            if (word.charAt(0) == FIRST_WORD) {
                wordsFilteredArray[counter] = word;
                counter++;
            }
        }

        Arrays.sort(wordsFilteredArray);
        return wordsFilteredArray;
    }
}
