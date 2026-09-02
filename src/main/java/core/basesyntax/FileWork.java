package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str = stringBuilder.toString();
        if (str.isEmpty()) {
            return new String[0];
        }
        String[] toArray = str.trim().split("\\W+");
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < toArray.length; i++) {
            char[] symbols = toArray[i].toCharArray();
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[0] == 'w' || symbols[0] == 'W') {
                    for (int k = 0; k < symbols.length; k++) {
                        if (symbols[k] != '.' && symbols[k] != ','
                                    && symbols[k] != '?'
                                    && symbols[k] != '!' && symbols[k] != '\r'
                                    && symbols[k] != '\n') {
                            stringBuilder1.append(symbols[k]);
                        }
                    }
                    stringBuilder1.append(" ");
                    break;

                }
            }
        }
        String string = stringBuilder1.toString();
        if (string.isEmpty()) {
            return new String[0];
        }
        string = string.toLowerCase();
        String[] result = string.split(" ");
        Arrays.sort(result);

        return result;
    }
}
