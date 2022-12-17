package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileWork {

    private final StringBuilder filter = new StringBuilder();
    private boolean isFiltering = false;
    private String[] result = new String[0];

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            final StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();

            while (value != -1) {
                stringBuilder.append((char) value);
                if (stringBuilder.length() > 1) {
                    value = reader.read();
                    if (((char) value == 'w'
                            || (char) value == 'W')
                            && (stringBuilder.charAt(stringBuilder.length() - 1)
                            == ' ' || stringBuilder.charAt(stringBuilder.length() - 1) == '\n')) {
                        isFiltering = true;
                    }
                } else if (stringBuilder.length() > 0
                        && (char) value == 'w'
                        || (char) value == 'W') {
                    value = reader.read();
                    filter.append('w');
                    isFiltering = true;
                } else {
                    if ((char) value == 'w') {
                        isFiltering = true;
                    }
                }
                if (isFiltering) {
                    if ((char) value == ' '
                            || (char) value == '.'
                            || (char) value == ','
                            || (char) value == '!'
                            || (char) value == '?'
                            || (char) value == '\n') {
                        isFiltering = false;
                        filter.append(' ');
                    } else {
                        filter.append((char) value);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (filter.isEmpty()) {
            return result;
        } else {
            result = filter.toString().split("\\W+");
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i].toLowerCase();
        }
        result = Stream.of(result).sorted().toArray(String[]::new);

        return result;
    }
}
