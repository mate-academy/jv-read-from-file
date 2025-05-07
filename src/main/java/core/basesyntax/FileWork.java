package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char SPECIFIED_CHARACTER = 'w';
    public static final int SPECIFIED_CHARACTER_INDEX = 0;

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            //Checking whether the file is empty and returning an empty Array if the file is empty
            if (value == -1) {
                return new String[]{};
            }
            //Reading the file and creating an Array with lowercase words without punctuation
            StringBuilder builder = new StringBuilder();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            String fileContent = builder.toString().toLowerCase();
            String[] words = fileContent.split("\\W+");
            //Returning an empty Array if there is no suitable words
            if (startWithwWordsNumber(words) == 0) {
                return new String[]{};
            }
            //Creating naturally sorted Array with "w" words
            String[] startWithwWords = new String[startWithwWordsNumber(words)];
            int index = 0;
            for (String word: words) {
                if (word.charAt(SPECIFIED_CHARACTER_INDEX) == SPECIFIED_CHARACTER) {
                    startWithwWords[index] = word;
                    index++;
                }
            }
            Arrays.sort(startWithwWords);
            return startWithwWords;

        } catch (IOException e) {
            throw new RuntimeException("Can not read file " + fileName, e);
        }
    }

    public int startWithwWordsNumber(String[] array) {
        int counter = 0;
        for (String word: array) {
            if (word.charAt(SPECIFIED_CHARACTER_INDEX) == SPECIFIED_CHARACTER) {
                counter++;
            }
        }
        return counter;
    }
}
