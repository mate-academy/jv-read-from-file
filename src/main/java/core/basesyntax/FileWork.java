package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();

            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String result = stringBuilder.toString().toLowerCase();
            String[] array = result.split("\\W+");
            if (stringBuilder.length() == 0) {
                return new String[0];
            }
            int count = 0;
            for (String word : array) {
                if (word.charAt(0) == 'w') {
                    count++;
                }
            }
            String[] newArray = new String[count];
            int indexOrder = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i].charAt(0) == 'w') {
                    newArray[indexOrder] = array[i];
                    indexOrder++;
                }
            }

            Arrays.sort(newArray);
            return newArray;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t read file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }

    }
}
