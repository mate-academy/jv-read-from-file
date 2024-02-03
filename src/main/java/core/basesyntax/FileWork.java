package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final char SORT_CHAR = 'w';
    private static final int FIRST_CHAR_INDEX = 0;
    private static final String[] EMPTY_RESULT = new String[0];

    public String[] readFromFile(String fileName) {
        StringBuilder readResult = new StringBuilder();
        File file = new File(fileName);
        ArrayList<String> resultList = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                readResult.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            if (readResult.isEmpty()) {
                return EMPTY_RESULT;
            }
            String[] words = readResult.toString().split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().charAt(FIRST_CHAR_INDEX) == SORT_CHAR) {
                    resultList.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file");
        }
        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
