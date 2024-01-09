package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String WORD_STARTING = "^[w].*";
    private static final String FILTER_REGEX = "\\W+";
    private static final int EMPTY_SIZE = 0;
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        String[] stringsReader = null;
        File file = new File(fileName);
        try (FileInputStream fileInStream = new FileInputStream(file)) {
            if (fileInStream.available() == EMPTY_SIZE) {
                stringsReader = new String[EMPTY_SIZE];
            } else {
                bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] onlyWords = line.toLowerCase().split(FILTER_REGEX);
                    for (String word : onlyWords) {
                        if (word.matches(WORD_STARTING)) {
                            stringBuilder.append(word).append(SEPARATOR);
                        }
                    }
                }
                stringsReader = (stringBuilder.toString().length() == 0)
                        ? new String[EMPTY_SIZE]
                        : stringBuilder.toString().split(SEPARATOR);
                bubbleSort(stringsReader);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }
        return stringsReader;
    }

    private void bubbleSort(String[] array) {
        boolean isSorted = false;
        String temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 1) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
