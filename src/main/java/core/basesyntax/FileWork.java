package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String First_Letter = "w";
    private static final int ZERO = 0;

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }

            String text = builder.toString().toLowerCase();
            String[] split = text.split("\\W+");
            int count = ZERO;

            for (String words : split) {
                if (words.startsWith(First_Letter)) {
                    count++;
                }
            }
            String[] result = new String[count];
            int resultIndex = ZERO;
            for (String array : split) {
                if (array.startsWith(First_Letter)) {
                    result[resultIndex] = array;
                    resultIndex++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
    }
}
