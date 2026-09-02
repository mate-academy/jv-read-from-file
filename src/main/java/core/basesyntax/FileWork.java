package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX = "\\W+";
    private static final char FIRST_LETTER = 'w';
    private int countOfFilterWords = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[] {};
        }
        String[] words = stringBuilder.toString().toLowerCase().split(REGEX);
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == FIRST_LETTER) {
                countOfFilterWords++;
            }
        }
        String[] filterWords = new String[countOfFilterWords];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; i < words.length; i++) {
                if (words[i].charAt(0) == FIRST_LETTER) {
                    filterWords[j] = words[i];
                    j++;
                }
            }
        }
        Arrays.sort(filterWords);
        return filterWords;
    }
}

