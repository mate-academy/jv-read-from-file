package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final char WORD_START_SYMBOL = 'w';

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + fileName, e);
        }
        String[] outPutStringArray = stringBuilder.toString().toLowerCase().split("\\W+");
        int count = 0;
        for (String word : outPutStringArray) {
            if (word.charAt(0) == WORD_START_SYMBOL) {
                count++;
            }
        }
        String[] resultArr = new String[count];
        for (int i = 0, j = 0; i < outPutStringArray.length; i++) {
            if (outPutStringArray[i].charAt(0) == WORD_START_SYMBOL) {
                resultArr[j] = outPutStringArray[i];
                j++;
            }
        }
        return sortArray(resultArr);
    }

    public String[] sortArray(String[] array) {
        int size = array.length;
        String temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
