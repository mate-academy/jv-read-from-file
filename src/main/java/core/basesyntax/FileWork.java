package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final static String DEFAULT_DELIMETER = " ";

    public String[] readFromFile(String fileName) {
        String text = getText(fileName);
        if (text.length() == 0) {
            return new String[] {};
        }
        String trimmedText = getTrimmedTextText(text);
        String[] words = getWords(trimmedText);
        String[] fileredWords = filteredWords(words, 'w');
        Arrays.sort(fileredWords);
        return fileredWords;
    }

    private String[] filteredWords(String[] words, char firstLater) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            char head = word.charAt(0);
            if (head != firstLater) {
                continue;
            }
            stringBuilder.append(word);
            if (i == words.length - 1) {
                continue;
            }
            stringBuilder.append(DEFAULT_DELIMETER);
        }
        String result = stringBuilder.toString();
        if (result.length() == 0) {
            return new String[]{};
        }
        return result.split(DEFAULT_DELIMETER);
    }

    private String[] getWords(String trimmedText) {
        return trimmedText.split(DEFAULT_DELIMETER);
    }

    private String getTrimmedTextText(String text) {
        return text
                .toLowerCase()
                .trim()
                .replace('?', ' ')
                .replace('!', ' ')
                .replace(';', ' ')
                .replace('.', ' ')
                .replace(',', ' ')
                .trim().replaceAll("  ", " ");
    }

    private String getText(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line).append(DEFAULT_DELIMETER);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open file ", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read line. ", e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Can't close file. ", e);
            }
        }
        return stringBuilder.toString();
    }
}
