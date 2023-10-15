package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char firstCharacterW = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (fileName.isEmpty()) {
            return new String[0];
        }
        String newline;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((newline = bufferedReader.readLine()) != null) {
                String[] lineWords = newline
                        .toLowerCase()
                        .split("\\W+");
                for (String item : lineWords) {
                    if (item.charAt(0) == firstCharacterW) {
                        stringBuilder
                                .append(item.toLowerCase())
                                .append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + fileName, e);
        }
        String[] output = stringBuilder.toString().split(" ");
        Arrays.sort(output);
        return (output[0].isEmpty()) ? new String[]{} : output;
    }
}
