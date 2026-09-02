package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (getArraysLength(file) == 0) {
            return new String[0];
        }
        String[] result = new String[getArraysLength(file)];
        int count = 0;
        for (int i = 0; i < arrayFile(file).length; i++) {
            char[] charArray = arrayFile(file)[i].toCharArray();
            if (charArray[0] == 'w') {
                result[count] = arrayFile(file)[i];
                count++;
            }
        }
        Arrays.sort(result, Comparator.naturalOrder());
        return result;
    }

    public String[] arrayFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(File.separator);
                value = reader.readLine();
            }
            String allWords = stringBuilder.toString().toLowerCase();
            String[] arraysWords = allWords.split("\\W+");
            return arraysWords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    public int getArraysLength(File file) {
        int lengthNewArray = 0;
        if (arrayFile(file).length == 0) {
            return 0;
        }
        for (int i = 0; i < arrayFile(file).length; i++) {
            char[] charArray = arrayFile(file)[i].toCharArray();
            if (charArray[0] == 'w') {
                lengthNewArray++;
            }
        }
        return lengthNewArray;
    }
}
