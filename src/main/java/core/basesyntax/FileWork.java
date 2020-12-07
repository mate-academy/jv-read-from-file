package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_CHARACTER_TO_FILTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        String newLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((newLine = bufferedReader.readLine()) != null) {
                String[] lineWords = newLine.toLowerCase().split("\\W+");
                for (String item : lineWords) {
                    if (item.charAt(0) == FIRST_CHARACTER_TO_FILTER) {
                        stringBuilder.append(item.toLowerCase()).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + fileName, e);
        }
        String[] output = stringBuilder.toString().split(" ");
        Arrays.sort(output);
        return (output[0].isEmpty()) ? new String[] {} : output;
    }
}
