package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        if (file.length() == 0) {
            return new String[0];
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + fileName);
        }
        String[] bufferArray = builder.toString().split("\\W+");
        Arrays.sort(bufferArray);
        StringBuilder builderSorted = new StringBuilder();
        for (String string : bufferArray) {
            if (string.startsWith(SPECIFIED_CHARACTER)) {
                builderSorted.append(string).append(" ");
            }
        }
        String[] result = builderSorted.toString().split(" ");
        return result.length == 1 ? new String[0] : result;
    }
}
