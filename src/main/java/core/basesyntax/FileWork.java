package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_LETTER_INDEX = 0;
    private static final char SEARCHED_LETTER = 'w';

    public static String[] readFromFile(String fileName) {
        StringBuilder stringBuider = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                String[] emptyArr = {};
                return emptyArr;
            }
            while (value != null) {
                stringBuider.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file with name: " + fileName, e);
        }
        String[] splitedString = stringBuider.toString().toLowerCase().split("\\W+");
        int counter = 0;
        for (String string : splitedString) {
            if (string.charAt(FIRST_LETTER_INDEX) == SEARCHED_LETTER) {
                counter++;
            }
        }
        String[] stringArray = new String[counter];
        if (counter == 0) {
            return stringArray;
        }
        for (String string : splitedString) {
            if (string.charAt(FIRST_LETTER_INDEX) == SEARCHED_LETTER) {
                counter--;
                stringArray[counter] = string;
            }
        }
        Arrays.sort(stringArray);
        return stringArray;
    }
}
