package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        int count = 0;
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append("\n");
                value = bufferedReader.readLine();
            }
            String stringBuilderToString = stringBuilder.toString();
            if (stringBuilderToString.length() == 0) {
                return EMPTY_ARRAY;
            }
            String[] arrOfStr = stringBuilderToString.split("\\W+");
            for (String arrOfStrs : arrOfStr) {
                if (arrOfStrs.charAt(0) == 'w' || arrOfStrs.charAt(0) == 'W') {
                    count++;
                }
            }
            String[] result = new String[count];
            int number = 0;
            for (int i = 0; i < arrOfStr.length; i++) {
                if (arrOfStr[i].charAt(0) == 'w' || arrOfStr[i].charAt(0) == 'W') {
                    result[number] = arrOfStr[i].toLowerCase();
                    number++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file");
        }
    }
}
