package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] strings = stringBuilder.toString().toLowerCase().split("\\W+");
        Arrays.sort(strings);
        StringBuilder resultBuilder = new StringBuilder();
        for (String element : strings) {
            resultBuilder.append(element.charAt(0) == 'w' ? element + " " : "");
        }
        return resultBuilder.length() == 0 ? new String[0] : resultBuilder.toString().split(" ");
    }
}
