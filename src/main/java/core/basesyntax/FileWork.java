package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String[] results = new String[10];
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                String[] words = value.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.charAt(0) == 'w') {
                        results[i++] = word;
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (file.length() == 0 || results[0] == null) {
            results = new String[0];
            return results;
        }
        return getNewArray(results);
    }

    public String[] getNewArray(String[] array) {
        int newArrayLength = 0;
        for (String s : array) {
            if (s != null) {
                newArrayLength++;
            }
        }
        String[] newArray = new String[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        Arrays.sort(newArray);
        return newArray;
    }
}
