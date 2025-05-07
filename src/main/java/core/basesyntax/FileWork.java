package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = null;
        String[] result;

        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader(new File(fileName)))) {
            stringBuilder = new StringBuilder();
            String textFileName = bufferedReader.readLine();
            if (textFileName == null) {
                return new String[0];
            }
            while (textFileName != null) {
                textFileName = textFileName.toLowerCase().replaceAll("[!?.,]", "");
                String[] words = textFileName.split(" ");
                for (String word : words) {
                    if (word.charAt(0) == SPECIFIED_CHARACTER) {
                        stringBuilder.append(word).append(" ");
                    }
                }
                textFileName = bufferedReader.readLine();
            }
            if (stringBuilder.length() == 0) {
                return new String[0];
            }
            result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException("Can`t find the file", e);
        }
        return result;
    }
}
