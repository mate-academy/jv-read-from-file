package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPACE = " ";
    private static final char TARGET_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        readLines(fileName, stringBuilder);
        if (isStringBuilderIsEmpty(stringBuilder)) {
            return new String[0];
        }

        String[] arrayFromFileName = stringBuilder.toString().toLowerCase().split("\\W+");
        stringBuilder.setLength(0);
        for (String word : arrayFromFileName) {
            if (word.charAt(0) == TARGET_LETTER) {
                stringBuilder.append(word).append(SPACE);
            }
        }

        if (isStringBuilderIsEmpty(stringBuilder)) {
            return new String[0];
        }

        return Arrays.stream(stringBuilder.toString().trim().split(SPACE))
                .sorted()
                .toArray(String[]::new);
    }

    private boolean isStringBuilderIsEmpty(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0) {
            return true;
        }
        return false;
    }

    private void readLines(String fileName, StringBuilder stringBuilder) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }
}
