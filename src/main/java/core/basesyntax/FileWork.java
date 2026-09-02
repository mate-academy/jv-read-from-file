package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final int ZERO_INDEX = 0;
    private static final int MINUS_ONE_INDEX = -1;

    public String[] readFromFile(String fileName) {
        String[] sortedArray;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder result = new StringBuilder();
            int value = bufferedReader.read();
            if (value == MINUS_ONE_INDEX) {
                return new String[ZERO_INDEX];
            }
            while (value != MINUS_ONE_INDEX) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String[] array = stringBuilder.toString().toLowerCase().split("[ .,?!\n]");
            for (String name : array) {
                if (name.startsWith("w")) {
                    result.append(name).append(",");
                }
            }
            if (result.length() == ZERO_INDEX) {
                return new String[ZERO_INDEX];
            }
            sortedArray = result.toString().split(",");
            String temp;
            for (int i = 0; i < sortedArray.length; i++) {
                for (int j = i + 1; j < sortedArray.length; j++) {
                    if (sortedArray[i].compareTo(sortedArray[j]) > ZERO_INDEX) {
                        temp = sortedArray[i];
                        sortedArray[i] = sortedArray[j];
                        sortedArray[j] = temp;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
        return sortedArray;
    }
}
