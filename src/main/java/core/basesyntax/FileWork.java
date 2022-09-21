package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPLITERATOR = "\\W+";
    private static final String STARTS_WITH_LETTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String stringLine;
            while ((stringLine = bufferedReader.readLine()) != null) {
                strings = stringLine.toLowerCase().split(SPLITERATOR);
                for (String s : strings) {
                    if (s.startsWith(STARTS_WITH_LETTER)) {
                        stringBuilder.append(s).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        strings = stringBuilder.toString().trim().split(SPLITERATOR);
        Arrays.sort(strings);
        return strings;
    }
}
