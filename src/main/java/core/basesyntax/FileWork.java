package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char WANTED_LETTER = 'w';

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
            throw new RuntimeException(e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] fileToWordsArray = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder builderResult = new StringBuilder();
        for (String word : fileToWordsArray) {
            if (word.charAt(0) == WANTED_LETTER) {
                builderResult.append(word).append(" ");
            }
        }
        if (builderResult.length() == 0) {
            return new String[0];
        }
        String[] result = builderResult.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}

