package core.basesyntax;

import java.io.*;
import java.util.*;

public class FileWork {
    private static final char LETTER_W = 'w';
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] result;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String text = getTextFromReader(bufferedReader);
            if (text.isEmpty()) {
                return new String[0];
            }
            String[] words = text.split("\\W+");
            result = getWordsWithFirstW(words);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private String getTextFromReader(BufferedReader reader) {
        StringBuilder result = new StringBuilder();
        reader.lines().forEach(s -> {
            result.append(s).append("\n");
        });
        return result.toString();
    }

    private String[] getWordsWithFirstW(String[] words) {
        String[] result = new String[getCountWordsWithFirstW(words)];
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            if (words[i].charAt(0) == LETTER_W) {
                result[index++] = words[i];
            }
        }
        return sortArrayByAlphabet(result);
    }

    private int getCountWordsWithFirstW(String[] words) {
        int countWordsWithFirstW = 0;
        for (String word : words) {
            word = word.toLowerCase();
            if (word.charAt(0) == FileWork.LETTER_W) {
                countWordsWithFirstW++;
            }
        }
        return countWordsWithFirstW;
    }

    private String[] sortArrayByAlphabet(String[] words) {
        List<String> wordsArray = new ArrayList<>(List.of(words));
        Collections.sort(wordsArray);
        return wordsArray.toArray(new String[0]);
    }
}
