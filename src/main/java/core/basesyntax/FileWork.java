package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder builder = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            builder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                if (value == 87 || value == 119) {
                    builder.append((char) value);
                    value = reader.read();
                    while (value != 20 && value != 44 && value != 46 && value != 33 && value != 40
                            && value != 41 && value != 45 && value != 34 && value != 32
                            && value != 63) {
                        builder.append((char) value);
                        value = reader.read();
                    }
                    builder.append(" ");
                }
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't read.", e);
        }
        String[] wordsStartW = builder.toString().split(" ");
        for (int i = 0; i < wordsStartW.length; i++) {
            wordsStartW[i] = wordsStartW[i].toLowerCase();
        }
        Arrays.sort(wordsStartW);
        return wordsStartW;
    }

}
