package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static String[] getWWordsArray(int resultArrayLength, String[] readedWordsArray) {
        String[] resultArray = new String[resultArrayLength];
        int resultArrayNextIndex = 0;
        for (String word : readedWordsArray) {
            if (word.charAt(0) == 'w') {
                resultArray[resultArrayNextIndex] = word;
                resultArrayNextIndex++;
            }
        }
        return resultArray;
    }

    private static int getResultArrayLength(String[] readedWordsArray) {
        int resultArrayLength = 0;
        for (String word : readedWordsArray) {
            if (word.charAt(0) == 'w') {
                resultArrayLength++;
            }
        }
        return resultArrayLength;
    }

    private static String getParsedText(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int valueOfReader = reader.read();
        StringBuilder stringBuilder = new StringBuilder();
        while (valueOfReader != -1) {
            stringBuilder.append((char) valueOfReader);
            valueOfReader = reader.read();
        }
        reader.close();
        String readedString = stringBuilder.toString().toLowerCase();
        return readedString;
    }

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.length() == 0) {
            String[] emptyResult = new String[0];
            return emptyResult;
        }
        try {
            String readedString = getParsedText(file);
            String[] readedWordsArray = readedString.split("\\W+");
            int resultArrayLength = getResultArrayLength(readedWordsArray);
            String[] resultArray = getWWordsArray(resultArrayLength, readedWordsArray);
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
