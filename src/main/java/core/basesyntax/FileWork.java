package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] array;
        String[] tmpArray;
        File file = new File(fileName);
        StringBuilder wordsFromFile = new StringBuilder();
        int arraySize = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                wordsFromFile.append((char) value);
                value = bufferedReader.read();
            }

            if (wordsFromFile.length() == 0) {
                return new String[0];
            }

            tmpArray = new String[wordsFromFile.length()];
            tmpArray = wordsFromFile.toString().split("\\W+");

            for (int i = 0;i < tmpArray.length;i++) {
                if (tmpArray[i].charAt(0) == 'w' || tmpArray[i].charAt(0) == 'W') {
                    arraySize++;
                }
            }

            array = new String[arraySize];

            int j = 0;

            for (int i = 0;i < tmpArray.length;i++) {
                if (tmpArray[i].charAt(0) == 'w' || tmpArray[i].charAt(0) == 'W') {
                    array[j] = tmpArray[i];
                    array[j] = array[j].toLowerCase();
                    j++;
                }
            }

            Arrays.sort(array);
        } catch (IOException e) {
            throw new RuntimeException("Can not read from this file", e);
        }
        return array;
    }
}
