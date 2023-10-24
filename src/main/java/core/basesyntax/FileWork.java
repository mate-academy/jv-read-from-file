package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) throws RuntimeException {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            do {
                line = reader.readLine();
                filterLine(line, builder);
            } while (line != null);

            String result = builder.toString();
            if (result.isEmpty()) {
                return new String[0];
            }
            String[] resultArray = result.split(" ");
            Arrays.sort(resultArray);
            return resultArray;

        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file: " + fileName, e);
        }
    }

    private void filterLine(String line, StringBuilder builder) {
        if (line == null) {
            return;
        }

        String[] strings = line.split("\\W+");

        for (String string: strings) {
            if (string.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                builder.append(string.toLowerCase()).append(" ");
            }
        }
    }
}
