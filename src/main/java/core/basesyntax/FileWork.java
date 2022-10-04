package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final String letter = "w";
    private int index = 0;
    private int massivIndex = 0;
    private String[] result = new String[0];

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        if (file.length() == 0) {
            return new String[]{};
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] split = builder.toString().replaceAll("\\W+", " ").split(" ");
            for (String test : split) {
                if (test.toLowerCase().startsWith(letter)) {
                    index++;
                }
            }
            result = new String[index];
            for (String test1 : split) {
                if (test1.substring(0, 1).toLowerCase().equals(letter)) {
                    result[massivIndex] = test1.toLowerCase().replaceAll("\\W+", "");
                    massivIndex++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read this file");
        }
    }
}
