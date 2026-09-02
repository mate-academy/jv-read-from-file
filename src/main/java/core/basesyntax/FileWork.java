package core.basesyntax;

import static java.lang.Integer.valueOf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        // StringBuilder which will be used to contamination
        StringBuilder builder = new StringBuilder();
        // letterToFind declared
        String letterToFind = "w";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();

            while (value != -1) {
                builder.append((char)value);
                value = reader.read();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        // changing StringBuilder into string low case array and removing line feeds
        String stringFromBuilder = builder.toString().toLowerCase().replace("\n"," ");
        String[] seperatedWords = stringFromBuilder.split(" ");

        int arrayLength = 0;
        for (String word : seperatedWords) {
            if (word.startsWith(letterToFind)) {
                arrayLength++;
            }
        }

        // picking words
        String[] setOfWordsWithPunctuation = new String[arrayLength];
        int index = 0;
        for (String word : seperatedWords) {
            if (word.startsWith(letterToFind)) {
                setOfWordsWithPunctuation[index] = word;
                index++;
            }
        }

        // if there was no word begging from letter returning empty array,
        // else return sorted words with no punctuation
        if (index == 0) {
            return new String[] {};
        } else {
            // removing punctuation
            String[] setOfWords = new String[arrayLength];
            for (int i = 0; i < setOfWordsWithPunctuation.length; i++) {
                char[] letters = setOfWordsWithPunctuation[i].toCharArray();
                setOfWords[i] = "";
                for (char letter : letters) {
                    if (valueOf((int) letter) > 96 && valueOf((int) letter) < 123) {
                        setOfWords[i] = setOfWords[i] + letter;
                    }
                }
            }
            Arrays.sort(setOfWords);
            return setOfWords;
        }

    }
}
