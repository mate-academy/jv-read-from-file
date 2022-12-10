package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char FIRST_WORD_LETTER = 'w';
    public static final String REGEX_EXPRESSION = "\\W+";
    public static final String WHITESPACE = " ";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();

            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(WHITESPACE);
                value = bufferedReader.readLine();
            }

            String[] stringArray = builder.toString().toLowerCase().split(REGEX_EXPRESSION);
            builder.setLength(0);

            for (String strValue : stringArray) {
                if (strValue.charAt(0) == FIRST_WORD_LETTER) {
                    builder.append(strValue).append(WHITESPACE);
                }
            }
            String checkArrayAfterFiltering = builder.toString();

            if (checkArrayAfterFiltering.isEmpty()) {
                return new String[0];
            }
            String[] stringResult = checkArrayAfterFiltering.split(WHITESPACE);
            Arrays.sort(stringResult);
            bufferedReader.close();
            return stringResult;
        } catch (IOException ioException) {
            throw new RuntimeException("File is not read", ioException);
        }
    }
}
