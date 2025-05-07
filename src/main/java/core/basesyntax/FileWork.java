package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPLIT_PATTERN = "[^Wa-z]+";
    private static final int LENGTH_EMPTY_ARRAY = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilderReadFile = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[LENGTH_EMPTY_ARRAY];
            } else {
                while (value != null) {
                    stringBuilderReadFile.append(value).append(" ");
                    value = bufferedReader.readLine();
                }
                String[] splitsText = stringBuilderReadFile.toString().split(SPLIT_PATTERN);
                StringBuilder stringBuilder = new StringBuilder();
                for (String wordFromText : splitsText) {
                    if (wordFromText.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(wordFromText).append(" ");
                    }
                }
                String wordBeginLetterW = stringBuilder.toString().toLowerCase();
                if (wordBeginLetterW.length() == 0) {
                    return new String[LENGTH_EMPTY_ARRAY];
                } else {
                    String[] arrayWordBeginLetterW = wordBeginLetterW.split(" ");
                    Arrays.parallelSort(arrayWordBeginLetterW);
                    return arrayWordBeginLetterW;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
