package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char FIRST_CHARACTER_TO_FILTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String newLine = bufferedReader.readLine();
            while (newLine != null) {
                String[] lineWords = newLine.toLowerCase().split("\\W+");
                for (String item : lineWords) {
                    if (item.toLowerCase().charAt(0) == FIRST_CHARACTER_TO_FILTER) {
                        stringBuilder.append(item.toLowerCase()).append(" ");
                    }
                }
                newLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        } finally {
            String[] output = stringBuilder.toString().split(" ");
            Arrays.sort(output);
            System.out.println(output);
            return (output[0].equals("")) ? new String[] {} : output;
        }

    }
}
