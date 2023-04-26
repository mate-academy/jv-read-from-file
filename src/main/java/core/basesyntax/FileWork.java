package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char SPECIAL_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String result = builder.toString().replaceAll("[!?.,]", "").toLowerCase();
        String[] array = result.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String test : array) {
            if (test.length() > 0 && test.charAt(0) == SPECIAL_LETTER) {
                stringBuilder.append(test).append(" ");
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            return new String[]{};
        }
        String[] resultArray = stringBuilder.toString().split("\\W+");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
