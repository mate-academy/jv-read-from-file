package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char LOWER_LETTER_W = 'w';
    private static final char UPPER_LETTER_W = 'W';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String fileToString = getString(file);
        String allWords = filter(fileToString).toLowerCase();
        String[] result;
        if (fileToString.isEmpty() || allWords.isEmpty()) {
            return new String[0];
        } else {
            result = allWords.split("\\W+");
        }
        Arrays.sort(result);
        return result;
    }

    private static String getString(File file) {
        String fileToString;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            fileToString = stringBuilder.toString();

        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return fileToString;
    }

    public String filter(String fileToString) {
        String [] splitString = fileToString.split(" ");
        StringBuilder wordsStartsW = new StringBuilder();
        for (int i = 0; i < splitString.length; i++) {
            char [] x = splitString[i].toCharArray();
            for (int q = 0; q < x.length;) {
                if (x[q] == LOWER_LETTER_W || x[q] == UPPER_LETTER_W) {
                    wordsStartsW.append(splitString[i])
                            .append(" ");
                    break;
                }
                break;
            }
        }
        return wordsStartsW.toString();
    }
}
