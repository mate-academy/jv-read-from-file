package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char SEARCHED_LETTER = 'w';
    public static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        if (fileName.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] stringArray = data.toLowerCase().split("\\W+");
                for (String word : stringArray) {
                    if (word.charAt(0) == SEARCHED_LETTER) {
                        stringBuilder.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file", e);
        }

        if (stringBuilder.isEmpty()) {
            return new String[0];
        }

        String[] result = stringBuilder.toString().trim().split(SEPARATOR);
        Arrays.sort(result);
        return result;
    }
}
