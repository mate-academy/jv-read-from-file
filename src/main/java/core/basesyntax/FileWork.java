package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private static String NEW_LINE = System.lineSeparator();
    private static String ERROR_READER = "Can't read file";
    private static String EXPRESSION_REGULAR = "\\W";

    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(NEW_LINE);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR_READER, e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] arrayS = stringBuilder.toString().split(EXPRESSION_REGULAR);
        int count = 0;
        for (String s : arrayS) {
            String s1 = s.toLowerCase();
            if (s1.startsWith("w")) {
                count++;
            }
        }
        if (count == 0) {
            return new String[0];
        }
        String[] arrayResult = new String[count];
        int i = 0;
        for (String s : arrayS) {
            String s1 = s.toLowerCase();
            if (s1.startsWith("w")) {
                arrayResult[i] = s1;
                i++;
            }
        }
        Arrays.sort(arrayResult, Comparator.naturalOrder());
        return arrayResult;
    }
}
