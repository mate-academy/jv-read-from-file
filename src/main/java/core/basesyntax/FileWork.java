package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    public static final String LINE_SEPARATOR = " ";
    public static final char WORD_START = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            StringBuilder resultString = new StringBuilder();
            for (String string : strings) {
                resultString.append(getStartsWithLetterArray(string
                        .toLowerCase().split("\\W+"), WORD_START));
            }

            if (resultString.toString().isEmpty()) {
                return new String[0];
            }
            String[] resultArray = resultString.toString().split(LINE_SEPARATOR);
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }

    private String getStartsWithLetterArray(String[] line, char letter) {
        StringBuilder resString = new StringBuilder();
        for (String word : line) {
            if (word.toCharArray()[0] == letter) {
                resString.append(word).append(LINE_SEPARATOR);
            }
        }
        return resString.toString();
    }
}
