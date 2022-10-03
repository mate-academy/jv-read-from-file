package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String[0];
            }
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file",e);
        }
        String[] strings = builder.toString().split("\\W+");
        StringBuilder builder1 = new StringBuilder();
        for (String string : strings) {
            if (string.toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                builder1.append(string.toLowerCase()).append(" ");
            }
        }
        if (builder1.toString().length() == 0) {
            return new String[0];
        }
        String[] strgs = builder1.toString().split(" ");
        Arrays.sort(strgs);
        return strgs;
    }
}

