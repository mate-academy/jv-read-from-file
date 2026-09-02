package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEPARATOR = " ";
    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                value = wordFilter(value);
                if (value.isEmpty()) {
                    value = bufferedReader.readLine();
                    continue;
                }
                stringBuilder.append(value);
                value = bufferedReader.readLine();
                if (value != null) {
                    stringBuilder.append(SEPARATOR);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't be read!");
        }
        if (stringBuilder.length() == 0) {
            return new String[]{};
        }
        String[] sortResult = stringBuilder.toString().split(SEPARATOR);
        Arrays.sort(sortResult);
        return sortResult;
    }

    public boolean isStarts(String word) {
        return (word.toLowerCase().startsWith(LETTER));
    }

    public String wordFilter(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = line.split(SEPARATOR);
        for (int i = 0; i < words.length; i++) {
            if (isStarts(words[i])) {
                stringBuilder.append(SEPARATOR)
                        .append(words[i].replaceAll("[^A-za-z]", "").toLowerCase());
            }
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString().substring(1);
        }
        return "";
    }
}
