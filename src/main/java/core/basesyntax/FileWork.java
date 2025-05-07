package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String SYMBOLS_DELETE = "\\W+";
    private static final String SPACE_SYMBOL = " ";
    private static final char WORDS_FIRST_CHAR = 'w';
    private static final String ERROR_MESSAGE = "Could not read from file ";
    private static final int CHAR_POSITION = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        String[] noSymbArray;
        String valueOfFile;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            valueOfFile = br.readLine();
            while (valueOfFile != null) {
                sb.append(valueOfFile).append(SPACE_SYMBOL);
                valueOfFile = br.readLine();
            }
            if (sb.length() == 0) {
                return new String[] {};
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE, e);
        }

        noSymbArray = sb.toString().toLowerCase().split(SYMBOLS_DELETE);
        Arrays.sort(noSymbArray);
        sb = new StringBuilder();
        for (String arr : noSymbArray) {
            if (arr.charAt(CHAR_POSITION) == WORDS_FIRST_CHAR) {
                sb.append(arr).append(SPACE_SYMBOL);
            }
        }

        if (sb.length() == 0) {
            return new String[] {};
        } else {
            return sb.toString().split(SPACE_SYMBOL);
        }
    }
}
