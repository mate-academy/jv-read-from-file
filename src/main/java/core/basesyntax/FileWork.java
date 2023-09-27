package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int DEFAULT_ARRAY_LENGTH = 0;
    private static final int FIST_CHARACTER_INDEX = 0;
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String[] emptyArray = new String[DEFAULT_ARRAY_LENGTH];

    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            return emptyArray;
        }
        try {
            StringBuilder fileTextBuilder = new StringBuilder();
            StringBuilder wordsBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int value = bufferedReader.read();
            while (value != -1) {
                fileTextBuilder.append((char) value);
                value = bufferedReader.read();
            }
            // make fileTextBuilder lower case String array and remove unnecessary symbols
            String[] splitFileContent = fileTextBuilder.toString().toLowerCase()
                    .replaceAll("[^a-z]", " ").split(" ");
            for (String word : splitFileContent) {
                if (!word.isEmpty()
                        && word.toCharArray()[FIST_CHARACTER_INDEX]
                        == SPECIFIED_CHARACTER) {
                    wordsBuilder.append(word).append(" ");
                }
            }
            if (wordsBuilder.length() == 0) {
                return emptyArray;
            }
            String[] wordsFromW = wordsBuilder.toString().split(" ");
            Arrays.sort(wordsFromW);
            return wordsFromW;
        } catch (IOException e) {
            throw new RuntimeException("Can`t rea the file.", e);
        }
    }
}
