package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SPECIAL_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file", e);
        }
        String[] split = builder.toString().split("\\W+");
        StringBuilder resultBuilder = new StringBuilder();
        for (String s : split) {
            if (s.toLowerCase().startsWith(SPECIAL_LETTER)) {
                resultBuilder.append(s.toLowerCase(Locale.ROOT)).append(" ");
            }
        }
        if (resultBuilder.isEmpty()) {
            return new String[0];
        }
        String[] resultArray = resultBuilder.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
