package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder content = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                content.append(value).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String fullString = content.toString().trim().toLowerCase();
        if (fullString.length() > 0) {
            String[] splitFullString = fullString.split("\\W+");
            for (String split : splitFullString) {
                if (split.charAt(0) == 'w') {
                    builder.append(split).append(" ");
                }
            }
        }

        if (builder.toString().length() == 0) {
            return new String[0];
        } else {
            String[] result = builder.toString().trim().split(" ");
            Arrays.sort(result);
            return result;
        }
    }
}
