package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SYMBOL_W = "w";
    public static final String SYMBOL_W_UPPER_CASE = "W";
    
    public String[] readFromFile(String fileName) {
        StringBuilder words = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder word = new StringBuilder();
            int symbol = reader.read();
            while (symbol > 0) {
                if (Character.isAlphabetic(symbol)) {
                    word.append((char) symbol);
                } else {
                    if (word.toString().startsWith(SYMBOL_W_UPPER_CASE)
                            || word.toString().startsWith(SYMBOL_W)) {
                        words.append(word).append(" ");
                    }
                    word.setLength(0);
                }
                symbol = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = words.toString();
        if (result.equals("")) {
            return new String[]{};
        }
        String[] resultArray = result.toLowerCase().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
