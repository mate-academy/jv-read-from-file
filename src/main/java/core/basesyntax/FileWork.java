package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final int FIRST_UPPERCASE_LETTER_AT_ASCII = 65;
    private static final int LAST_UPPERCASE_LETTER_AT_ASCII = 90;
    private static final int FIRST_LOWERCASE_LETTER_AT_ASCII = 97;
    private static final int LAST_LOWERCASE_LETTER_AT_ASCII = 122;
    private static final int FIRST_SIGN = 32;
    private static final int LAST_SIGN = 63;
    private static final int CARRIAGE_RETURN = 13;
    private static final int LINE_FEED = 10;

    public String[] readFromFile(String fileName) {
        String data = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int value = reader.read();
            while (value != -1) {
                if ((value >= FIRST_UPPERCASE_LETTER_AT_ASCII
                        && value <= LAST_UPPERCASE_LETTER_AT_ASCII)
                        || (value >= FIRST_LOWERCASE_LETTER_AT_ASCII
                        && value <= LAST_LOWERCASE_LETTER_AT_ASCII)) {
                    data = data + (char)value;
                } else if (value >= FIRST_SIGN && value <= LAST_SIGN || value == CARRIAGE_RETURN) {
                    data += " ";
                }
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!");
        }
        data = data.toLowerCase();
        String[] stringArrayData = data.split(" ");
        String[] result = new String[checkQuantityOfRequiredWords(stringArrayData)];
        if (result.length == 0) {
            return result;
        }
        int count = 0;
        for (String word : stringArrayData) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                result[count] = word;
                count++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public int checkQuantityOfRequiredWords(String[] stringArrayData) {
        int count = 0;
        for (String word : stringArrayData) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        return count;
    }
}
