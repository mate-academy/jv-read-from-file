package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_LETTER_LOWERCASE = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
        String fileToLowerCase = stringBuilder.toString().toLowerCase();
        String[] splited = fileToLowerCase.split("[^A-Za-z]+");
        StringBuilder builder = new StringBuilder();
        for (String word : splited) {
            if ((word.charAt(0) == SPECIFIED_LETTER_LOWERCASE)) {
                builder.append(word).append(" ");
            }
        }
        String sorted = builder.toString();
        String[] sortedArray = sorted.split(" ");
        Arrays.sort(sortedArray);
        if (sortedArray.length == 1) {
            return new String[]{};
        }
        return sortedArray;
    }
}
