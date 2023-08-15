package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final char FIRST_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder wordsFromFile = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                wordsFromFile.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("You have a IOException", e);
        }
        if (wordsFromFile.toString().isEmpty()) {
            return new String[0];
        }
        String[] arrayOfWords = wordsFromFile.toString().split("[\\s\\p{Punct}]+");
        ArrayList<String> finalArray = new ArrayList<>();
        for (String word : arrayOfWords) {
            if (word.toLowerCase().charAt(0) == FIRST_LETTER) {
                finalArray.add(word.toLowerCase());
            }
        }
        Collections.sort(finalArray);
        return finalArray.toArray(new String[0]);
    }
}
