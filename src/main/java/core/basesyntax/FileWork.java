package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final int STOP_READING = -1;
    private static final int NEW_LINE = 10;
    private static final int SPACE_CHAR = 32;
    private static final int SYMBOL_FROM = 65;
    private static final int SYMBOL_TO = 122;
    private static final char SEARCHED_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder wholeText = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int symbol = bufferedReader.read();
            while (symbol != STOP_READING) {
                if (symbol >= SYMBOL_FROM && symbol <= SYMBOL_TO || symbol == SPACE_CHAR) {
                    wholeText.append((char) symbol);
                } else if (symbol == NEW_LINE) {
                    wholeText.append(" ");
                }
                symbol = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File couldn't be found", e);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read a file", e);
        }
        if (wholeText.length() != 0) {
            String[] wholeTextArray = wholeText.toString().toLowerCase().split(" ");
            Arrays.sort(wholeTextArray);
            List<String> wordsWithW = new ArrayList<>();

            for (String word : wholeTextArray) {
                if (word.charAt(0) == SEARCHED_SYMBOL) {
                    wordsWithW.add(word);
                }
            }
            return wordsWithW.toArray(new String[0]);
        }
        return new String[0];
    }
}
