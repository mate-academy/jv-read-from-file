package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SEARCH_WORD = "w";
    private static final String SPLITER = "\\W+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String stringLine;
            while ((stringLine = bufferedReader.readLine()) != null) {
                strings = stringLine.toLowerCase().split(SPLITER);
                for (String s : strings) {
                    if (s.startsWith(SEARCH_WORD)) {
                        stringBuilder.append(s).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        strings = stringBuilder.toString().trim().split(SPLITER);
        Arrays.sort(strings);
        return strings;
    }
}
