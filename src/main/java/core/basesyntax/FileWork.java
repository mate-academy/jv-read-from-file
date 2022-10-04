package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FILTER_VALUE = 'w';
    private static final String REGEX_FOR_WORDS = "[$&+,:;=?@#|'<>.-^*()%!\\r\\n ]+";
    private int counter = 0;

    public String[] readFromFile(String fileName) {

        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = 0;
            try {
                value = bufferedReader.read();
            } catch (IOException e) {
                throw new RuntimeException("Can't read file", e);
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                try {
                    value = bufferedReader.read();
                } catch (IOException e) {
                    throw new RuntimeException("Can't read file", e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.toString().length() == 0) {
            return new String[]{};
        }
        String[] split = stringBuilder.toString().toLowerCase().split(REGEX_FOR_WORDS);
        for (int i = 0; i < split.length; i++) {
            if (split[i].charAt(0) == FILTER_VALUE) {
                counter++;
            }
        }
        String[] result = new String[counter];
        for (int i = 0, j = 0; i < split.length; i++) {
            if (split[i].charAt(0) == FILTER_VALUE) {
                result[j] = split[i];
                j++;
            }
        }

        Arrays.sort(result);
        return result;
    }
}
