package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final String SPLIT = "\\W+";

    public String[] readFromFile(String fileName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[]{};
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String text = stringBuilder.toString();
            String lowerText = text.toLowerCase();
            String[] textArray = lowerText.split(SPLIT);
            Arrays.sort(textArray);
            int count = 0;

            for (String item : textArray) {
                if (item.charAt(0) == SPECIFIED_CHARACTER) {
                    count++;
                }
            }

            String [] result = new String[count];
            int resultIndex = 0;

            for (String s : textArray) {
                if (s.charAt(0) == SPECIFIED_CHARACTER) {
                    result[resultIndex] = s;
                    resultIndex++;
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }

    }
}
