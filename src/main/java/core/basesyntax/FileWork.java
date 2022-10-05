package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char FIRST_LETTER = 'w';
    public static final String SPACE = " ";

    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] stringSplit = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder builder = new StringBuilder();
        int arrayLength = 0;
        for (int i = 0; i < stringSplit.length; i++) {
            if (stringSplit[i].charAt(0) == FIRST_LETTER) {
                builder.append(stringSplit[i]).append(SPACE);
                arrayLength++;
            }
        }
        if (arrayLength == 0) {
            return new String[]{};
        }
        String[] result = builder.toString().split(SPACE);
        Arrays.sort(result);
        return result;
    }
}
