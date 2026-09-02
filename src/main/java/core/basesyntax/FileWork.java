package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORDS_SEPARATOR = "\\W+";
    private static final char FILTER_LETTER = 'w';

    public String[] readFromFile(String fileName) throws RuntimeException {
        File file = new File(fileName);

        String fileContent = getFileContent(file);

        if (fileContent == null || fileContent.isEmpty()) {
            return new String[0];
        }

        String[] wordsArr = splitStringIntoArr(fileContent);
        String[] resultArr = filterWordsByChar(wordsArr);

        Arrays.sort(resultArr, String.CASE_INSENSITIVE_ORDER);

        return resultArr;
    }

    private static String getFileContent(File file) throws RuntimeException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();

            while (value != -1) {
                stringBuilder.append((char)value);
                value = bufferedReader.read();
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }
    }

    private static String[] splitStringIntoArr(String content) {
        return content.split(WORDS_SEPARATOR);
    }

    private static String[] filterWordsByChar(String[] words) {
        int wordsCounter = 0;
        String lower = null;

        for (String word : words) {
            lower = word.toLowerCase();

            if (!lower.isEmpty() && lower.charAt(0) == FILTER_LETTER) {
                wordsCounter++;
            }
        }

        String[] resultArr = new String[wordsCounter];
        int index = 0;
        for (String word: words) {
            lower = word.toLowerCase();

            if (!lower.isEmpty() && lower.charAt(0) == FILTER_LETTER) {
                resultArr[index++] = lower;
            }
        }

        return resultArr;
    }
}
