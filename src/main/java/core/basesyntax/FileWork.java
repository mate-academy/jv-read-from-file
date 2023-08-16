package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder fullContent = new StringBuilder();
        StringBuilder resultContent = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = reader.readLine()) != null) {
                fullContent.append(value).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String fullString = fullContent.toString().trim().toLowerCase();
        if (fullString.length() > 0) {
            String [] splitFullString = fullString.split("\\W+");
            for (String split : splitFullString) {
                if (split.charAt(0) == 'w') {
                    resultContent.append(split).append(" ");
                }
            }
        }

        if (resultContent.toString().length() == 0) {
            return new String[0];
        } else {
            String[] result = resultContent.toString().trim().split(" ");
            Arrays.sort(result);
            return result;
        }
    }
}
