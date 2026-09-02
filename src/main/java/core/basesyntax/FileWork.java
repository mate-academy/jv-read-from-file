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
        String[] result = new String[getArraysLength(file)];
        int count = 0;
        String[] strings = fileToArray(file);
        for (int i = 0; i < strings.length; i++) {
            String[] newSplit = strings[i].split("\\W+");
            for (int j = 0; j < newSplit.length; j++) {
                char[] chars = newSplit[j].toCharArray();
                if (chars[0] == 'w') {
                    result[count] = newSplit[j];
                    count++;
                }
            }
        }
        if (result.length == 0) {
            return new String[0];
        }
        Arrays.sort(result, Comparator.naturalOrder());
        return result;
    }

    public static String[] fileToArray(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(File.separator);
                value = reader.readLine();
            }
            String allWords = builder.toString().toLowerCase();
            String[] array = allWords.split("\\W+");
            return array;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file.", e);
        }
    }

    public static int getArraysLength(File file) {
        int length = 0;
        for (int i = 0; i < fileToArray(file).length; i++) {
            String[] split = fileToArray(file)[i].split(" ");
            for (int j = 0; j < split.length; j++) {
                char[] wordChars = split[j].toCharArray();
                if (wordChars[0] == 'w') {
                    length++;
                }
            }
        }
        return length;
    }
}


