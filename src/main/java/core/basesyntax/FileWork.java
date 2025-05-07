package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found ",e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int value;
        try {
            value = bufferedReader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (value == -1) {
            return new String[0];
        }
        try {
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("Can't read file " + e);
        }

        String[] textArray = stringBuilder.toString().replaceAll("\n", " ").toLowerCase()
                .split(" ");
        int counterW = 0;

        for (String word: textArray) {

            if (word.charAt(0) == 'w') {
                counterW++;
            }
        }
        String[] wordArray = new String[counterW];
        int indexWordArray = -1;

        for (String word: textArray) {
            if (word.charAt(0) == 'w') {
                indexWordArray++;
                wordArray[indexWordArray] = word.replaceAll("[^a-zA-Z]", "");
            }
        }
        Arrays.sort(wordArray);
        return wordArray;
    }
}

