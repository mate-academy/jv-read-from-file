package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    static final String SEPARATOR = "";

    public String[] readFromFile(String fileName) {
        if (fileName.isEmpty()) {
            return new String[0];
        }
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String[] strings = stringBuilder.toString().toLowerCase().split("\\s+");
        StringBuilder resultBuilder = new StringBuilder();
        int count = 0;
        for (String string : strings) {
            String word = string.replaceAll("[^a-z]", SEPARATOR);
            System.out.println(word);
            if (!word.isEmpty() && word.charAt(0) == 'w') {
                resultBuilder.append(word).append(System.lineSeparator());
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }
        String[] sortedResult = resultBuilder.toString().trim().split(System.lineSeparator());
        Arrays.sort(sortedResult);

        return sortedResult;
    }
}
