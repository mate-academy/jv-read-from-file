package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char START_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = null;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File(fileName)))) {
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                for (String word : value.toLowerCase().split(" ")) {
                    if (word.charAt(0) == START_CHAR) {
                        stringBuilder.append(word.toLowerCase()
                                .replaceAll("[!?,.]","")).append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[] {};
        }
        String[] filterResult = stringBuilder.toString().split(" ");
        Arrays.sort(filterResult);
        return filterResult;
    }
}
