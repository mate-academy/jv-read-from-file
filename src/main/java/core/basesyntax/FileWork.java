package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class FileWork {
    private static final Pattern PATTERN = Pattern.compile("\\p{IsPunctuation}",
            Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        return readFiles(file);
    }

    private static String[] readFiles(File fileEntry) {
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(fileEntry));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value)
                        .append(" ");
                value = reader.readLine();
            }
            return wordsWFilter(builder);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    private static String[] wordsWFilter(StringBuilder builder) {
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] array = PATTERN.matcher(builder.toString())
                .replaceAll(" ")
                .replaceAll("\\s+", " ")
                .toLowerCase()
                .split(" ");

        builder.setLength(0);
        for (String str : array) {
            if (str.charAt(0) == 'w') {
                builder.append(str).append(":");
            }
        }
        return (builder.length() == 0) ? new String[0] : arraySort(builder.toString().split(":"));
    }

    private static String[] arraySort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
