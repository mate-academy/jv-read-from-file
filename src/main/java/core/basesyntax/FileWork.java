package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SYMBOL = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can`t read file" + e);
        }
        String[] arrayFile = stringBuilder.toString().split("[\\p{Punct}\\s]+");
        stringBuilder.setLength(0);

        for (int i = 0; i < arrayFile.length; i++) {
            arrayFile [i] = arrayFile [i].toLowerCase(Locale.ROOT);
            if (startWithLetter(arrayFile[i])) {
                stringBuilder.append(arrayFile [i]).append(" ");
            }
        }
        if (stringBuilder.length() == 0) {
            return new String [0];
        }
        String [] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);

        return result;
    }

    public boolean startWithLetter(String string) {
        return string.startsWith(SYMBOL);
    }
}
