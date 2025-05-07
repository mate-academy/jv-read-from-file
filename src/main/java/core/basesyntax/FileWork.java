package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] nonSort = stringBuilder.toString().split("\\W+");
            return sortedArray(nonSort);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }

    public String[] sortedArray(String[] array) {
        int count = 0;
        int countindex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].toLowerCase().charAt(0) == 'w') {
                count++;
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < array.length; i++) {
            if (array[i].toLowerCase().charAt(0) == 'w') {
                result[countindex] = array[i].toLowerCase();
                countindex++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
