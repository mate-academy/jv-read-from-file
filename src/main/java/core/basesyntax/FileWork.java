package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char START_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        System.out.println(fileName);
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(System.lineSeparator()).append(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong!", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("Something went wrong!", e);
            }
        }
        String[] result = getAllWordsStartingWithW(stringBuilder);
        result = sortArrayAlphabetically(result);
        return result;
    }

    private String[] getAllWordsStartingWithW(StringBuilder stringBuilder) {
        String[] words = stringBuilder.toString().split("\\W+");
        StringBuilder allWordsWithW = new StringBuilder();
        String[] result = new String[] {};
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (word.length() != 0 && lowerCaseWord.charAt(0) == START_CHARACTER) {
                allWordsWithW.append(lowerCaseWord).append(' ');
            }
        }
        if (allWordsWithW.length() != 0) {
            result = allWordsWithW.toString().split("\\s+");
        }
        return result;
    }

    private String[] sortArrayAlphabetically(String[] words) {
        Arrays.sort(words);
        return words;
    }
}
