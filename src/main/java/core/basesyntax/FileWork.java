package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String DELIMITERS = "[^A-Za-z0-9]";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            if (value == -1) {
                return new String[]{};
            }
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
            System.out.println(builder.toString());
            String[] array = builder.toString().toLowerCase().split(DELIMITERS);
            builder.setLength(0);
            for (String s : array) {
                if (s.startsWith(SPECIFIED_CHARACTER)) {
                    builder.append(s).append(" ");
                }
            }
            if (builder.length() == 0) {
                return new String[]{};
            }
            array = builder.toString().split(" ");
            Arrays.sort(array);
            return array;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
    }
}
