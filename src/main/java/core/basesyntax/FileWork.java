package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String DELIMITER = "\\W+";
    private static final String SPACE = " ";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(SPACE);
                value = bufferedReader.readLine();
            }

            String[] files = stringBuilder.toString().toLowerCase().split(DELIMITER);
            Arrays.sort(files);
            StringBuilder builder = new StringBuilder();
            for (String file : files) {
                if (file.startsWith(SPECIFIED_CHARACTER)) {
                    builder.append(file).append(SPACE);
                }
            }

            String[] array = builder.toString().split(SPACE);
            if (array.length == 1) {
                return new String[0];
            }
            return array;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
