package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                if (Character.isAlphabetic(value)
                        || Character.isSpaceChar(value)
                        || System.lineSeparator().indexOf((char) value) != -1) {
                    builder.append((char) value);
                }
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String text = builder.toString().toLowerCase().replace(System.lineSeparator(), " ");
        return sortStringInArray(text);
    }

    private String[] sortStringInArray(String string) {
        String[] strArray = splitBySpace(string);
        StringBuilder builder = new StringBuilder();
        for (String word : strArray) {
            if (word.startsWith("w")) {
                builder.append(word)
                        .append(" ");
            }
        }
        String[] result = splitBySpace(builder.toString());
        if (result.length == 1) {
            return new String[0];
        }
        Arrays.sort(result);
        return result;
    }

    private String[] splitBySpace(String string) {
        return string.trim().split("\\W+");
    }
}
