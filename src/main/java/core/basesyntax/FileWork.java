package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String REGEX = "[^\\p{L}\\p{Z}]";
    public static final String SPACE = " ";
    public static final String TARGET_MATCH = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] result = new String[0];

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String value = bufferedReader.readLine();
            if (value == null) {
                return result;
            }
            while (value != null) {
                String[] lines = value.toLowerCase().split(SPACE);
                for (String word : lines) {
                    if (word.startsWith(TARGET_MATCH)) {
                        stringBuilder
                                .append(word.replaceAll(REGEX, ""))
                                .append(SPACE);
                    }
                }
                value = bufferedReader.readLine();
            }
            if (stringBuilder.length() == 0) {
                return result;
            }
            result = stringBuilder.toString().split(SPACE);
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
