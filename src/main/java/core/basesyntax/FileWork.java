package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String NON_WORD_CHARACTER = "\\W+";
    private static final char CHAR_FILTER = 'w';

    public String[] readFromFile(String fileName) {
        String[] result = {};
        int index = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            if (!stringBuilder.toString().isEmpty()) {
                result = new String[fileName.length()];
                String[] split = stringBuilder.toString().toLowerCase().split(NON_WORD_CHARACTER);
                for (String string : split) {
                    if (string.charAt(0) == CHAR_FILTER) {
                        result[index] = string;
                        index++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] sortedResult = new String[index];
        System.arraycopy(result, 0, sortedResult, 0, index);
        Arrays.sort(sortedResult);
        return sortedResult;
    }
}
