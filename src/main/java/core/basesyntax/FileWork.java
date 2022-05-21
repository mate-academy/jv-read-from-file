package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String CHARACTERS_FOR_SPLIT = "\\W+";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder allWordsWithW = new StringBuilder();
            String lineFromFile = reader.readLine();
            if (lineFromFile == null) {
                return new String[0];
            }
            while (lineFromFile != null) {
                String[] splitString = lineFromFile.split(CHARACTERS_FOR_SPLIT);
                allWordsWithW.append(wordsContainingW(splitString));
                lineFromFile = reader.readLine();
            }
            String[] result = allWordsWithW.toString().split(",");
            if (result[0].isEmpty()) {
                return new String[0];
            }
            return sortStringArray(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Empty line", e);
        }

    }

    private String[] sortStringArray(String[] result) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < result.length; i++) {
                if (shouldSecondStringMove(result[i].toCharArray(), result[i - 1].toCharArray())) {
                    String tmp = result[i];
                    result[i] = result[i - 1];
                    result[i - 1] = tmp;
                    needIteration = true;
                }
            }
        }
        return result;
    }

    private boolean shouldSecondStringMove(char[] secondWord, char[] firstWord) {
        int compare;
        for (int i = 1; i < firstWord.length; i++) {
            compare = Character.compare(secondWord[i], firstWord[i]);
            if (compare < 0) {
                return true;
            }
            if (compare > 0) {
                return false;
            }
        }
        return false;
    }

    private boolean wordHaveW(String word) {
        return word.indexOf('w') == 0 || word.indexOf('W') == 0;
    }

    private StringBuilder wordsContainingW(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word: words) {
            if (wordHaveW(word)) {
                stringBuilder.append(word.toLowerCase()).append(",");
            }
        }
        return stringBuilder;
    }
}
