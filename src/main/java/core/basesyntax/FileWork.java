package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {

        final char LT = 'w';
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        int j = 0;
        String []split = new String[]{};

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            if (value == -1) {
                return split;
            }

            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file");
        }
        String sentence = String.valueOf(builder).toLowerCase(Locale.ROOT);
        split = sentence.split("\\W+");

        for (int i = 0; i < split.length; i++) {
            if (LT == split[i].charAt(0)) {
                counter++;
            }
        }

        String []result = new String[counter];
        for (int i = 0; i < split.length; i++) {

            if (LT == split[i].charAt(0)) {
                result[j] = split[i];
                j++;
            }
        }

        Arrays.sort(result);
        return result;

    }
}
