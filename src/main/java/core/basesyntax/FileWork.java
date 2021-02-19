package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[0];
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String[] wordsArray = stringBuilder.toString().split(" ");
            int countWordsWithW = 0;
            StringBuilder builderForWords = new StringBuilder();
            for (String word : wordsArray) {
                String replaceAll = word.replaceAll("\n", "+ ");
                String wordToLowwerCase = replaceAll.toLowerCase();
                if (wordToLowwerCase.charAt(0) == 'w') {
                    countWordsWithW += 1;
                    builderForWords.append(wordToLowwerCase).append(" ");
                }
            }
            if (builderForWords.length() == 0) {
                return new String[0];
            }
            String[] resultArray = builderForWords.toString().split(" ");

            for (int i = 0; i < resultArray.length; i++) {
                if (resultArray[i].endsWith(".") || resultArray[i].endsWith("!")
                        || resultArray[i].endsWith("?") || resultArray[i].endsWith("+")) {
                    String substring = resultArray[i].substring(0, resultArray[i].length() - 1);
                    resultArray[i] = substring;
                }
                if (resultArray[i].indexOf('.') > 0) {
                    String substring1 = resultArray[i].substring(0, resultArray[i].indexOf('.'));
                    resultArray[i] = substring1;
                }
            }
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

    }
}
