package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char STARTING_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                stringBuilder.append((char) symbol);
                symbol = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        if (stringBuilder.length() == 0) {
            return new String[]{};
        }

        // split at one or more non-word characters
        String[] words = stringBuilder.toString().toLowerCase().split("\\W+");
        // I reset the stringBuilder so I can reuse it
        stringBuilder.delete(0, stringBuilder.length());
        for (String word: words) {
            if (word.charAt(0) == STARTING_LETTER) {
                stringBuilder.append(word).append(" ");
            }
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] result = stringBuilder.toString().split("\\s");
        Arrays.sort(result);
        return result;
    }
}
