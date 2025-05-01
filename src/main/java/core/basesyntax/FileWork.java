package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String FILTER_FOR_DELIMITERS = "\\W+";
    private static final int ARRAY_EMPTY_INDEX = 0;
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] splitedFilename = null;
        String[] result = new String[ARRAY_EMPTY_INDEX];
        List<String> tempList = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readedLine = bufferedReader.readLine();
            while (readedLine != null) {
                stringBuilder.append(readedLine).append(" ");
                readedLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found..." + e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file..." + e);
        }

        if (stringBuilder.isEmpty()) {
            return result;
        } else {
            String temp = stringBuilder.toString().toLowerCase();
            splitedFilename = temp.split(FILTER_FOR_DELIMITERS);
        }

        if (splitedFilename.length != 0) {
            tempList = new ArrayList<>();
            for (String word : splitedFilename) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    tempList.add(word);
                }
            }
        }

        result = tempList.toArray(new String[ARRAY_EMPTY_INDEX]);
        Arrays.sort(result);
        return result;
    }
}
