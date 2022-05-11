package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int EMPTY_ARRAY_LENGTH = 0;
    private static final int EMPTY_BUILDER = 0;
    private final StringBuilder builder = new StringBuilder();
    private BufferedReader reader;
    private String[] resultArray;
    private String resultString = "";

    public String[] readFromFile(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        resultArray = builder.toString().toLowerCase().split("\\W+");
        builder.setLength(EMPTY_BUILDER);
        for (String str : resultArray) {
            if (str.startsWith("w")) {
                builder.append(str).append(" ");
            }
        }
        resultString = builder.toString();
        if (resultString.isEmpty()) {
            return new String[EMPTY_ARRAY_LENGTH];
        }
        resultArray = resultString.split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
