package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER_UPPERCASE = 'W';
    private static final char SPECIFIED_CHARACTER_LOWERCASE = 'w';

    public String[] readFromFile(String fileName) {
        int value;
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String data = new String();
        StringBuilder builder1 = new StringBuilder();
        data = builder.toString();
        String[] arrayOfW = new String[]{""};
        String[] arr = data.split("\\W+");
        for (String word : arr) {
            if (data.length() == 0) {
                return new String[]{};
            } else if (arr.length > 0) {
                if (word.charAt(0) == SPECIFIED_CHARACTER_LOWERCASE
                        || word.charAt(0) == SPECIFIED_CHARACTER_UPPERCASE) {
                    builder1.append(word.toLowerCase()).append(" ");
                }
            }
        }
        String str = builder1.toString().toLowerCase();
        if (str.equals("")) {
            return new String[]{};
        }
        arrayOfW = str.split(" ");
        Arrays.sort(arrayOfW);
        return arrayOfW;
    }
}
