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
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] data = builder.toString().toLowerCase().split("\\W");

            StringBuilder words = new StringBuilder();
            for (String lol: data) {
                if (lol.startsWith(SPECIFIED_CHARACTER)) {
                    words.append(lol).append(" ");
                }
            }
            if (words.length() == 0) {
                return new String[]{};
            }
            String[] total = words.toString().split(" ");
            Arrays.sort(total);
            return total;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
