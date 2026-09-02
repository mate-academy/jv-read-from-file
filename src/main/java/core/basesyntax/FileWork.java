package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[]{};
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                builder.append(readLine.toLowerCase()).append(System.lineSeparator());
                readLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found" + e);
        }
        String[] allText = builder.toString().split("\\W+");
        if (allText.length == 0) {
            return new String[] {};
        }
        StringBuilder builder1 = new StringBuilder();
        for (String s : allText) {
            if (s.charAt(0) == SPECIFIED_CHARACTER) {
                builder1.append(s).append(" ");
            }
        }
        if (builder1.length() == 0) {
            return new String[]{};
        }
        String[] result = builder1.toString().split("\\W+");
        Arrays.sort(result);
        return result;
    }
}
