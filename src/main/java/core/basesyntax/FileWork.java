package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String PATTERN = "w";

    public String[] getPattern(String a) {
        String result;
        String[] unSort = a.toLowerCase().split("\\W+");
        StringBuilder resultBuilder = new StringBuilder();
        for (String s : unSort) {
            if (s.startsWith(PATTERN)) {
                resultBuilder.append(s).append(" ");
            }
        }
        result = resultBuilder.toString();
        if (result.isEmpty()) {
            return new String[]{};
        }
        String[] forSort = result.split(" ");
        Arrays.sort(forSort);
        return forSort;
    }

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String data = bufferedReader.readLine();
            while (data != null) {
                builder.append(data).append(System.lineSeparator());
                data = bufferedReader.readLine();
            }
            return getPattern(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }
    }
}
