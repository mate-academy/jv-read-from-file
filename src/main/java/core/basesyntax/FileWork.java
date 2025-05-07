package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int ARRAY_LENGTH = 10;
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String[] results = new String[ARRAY_LENGTH];
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                String[] words = value.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        results[i++] = word;
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (file.length() == 0 || results[0] == null) {
            return new String[0];
        }
        return getSortedArray(results);
    }

    public String[] getSortedArray(String[] words) {
        int sortedArrayLength = 0;
        for (String word : words) {
            if (word == null) {
                break;
            }
            sortedArrayLength++;
        }
        String[] sortedArray = new String[sortedArrayLength];
        System.arraycopy(words, 0, sortedArray, 0, sortedArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
