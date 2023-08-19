package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CHARACTER_W = "w";
    private static final String PUNCTUATION = "\\W+";

    public String[] readFromFile(String fileName) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        StringBuilder builder = new StringBuilder();
        String value = null;
        try {
            value = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (value == null) {
            return new String[]{};
        }
        while (value != null) {
            builder.append(value).append(System.lineSeparator());
            try {
                value = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String newBuilder = builder.toString();

        String[] removePunctuation = newBuilder.toString().toLowerCase().split(PUNCTUATION);
        Arrays.sort(removePunctuation);

        int count = 0;
        for (int i = 0; i < removePunctuation.length; i++) {
            if (removePunctuation[i].indexOf(CHARACTER_W) == 0) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < removePunctuation.length; i++) {
            if (removePunctuation[i].indexOf(CHARACTER_W) == 0) {
                result[index] = removePunctuation[i];
                index++;
            }
        }
        return result;
    }
}
