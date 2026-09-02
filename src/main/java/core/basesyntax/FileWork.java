package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_CHARACTER = "w";
    private String [] filtered;

    public String[] readFromFile(String fileName) {

        //write your code here
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        StringBuilder newBuilder = new StringBuilder();
        String [] newArray = builder.toString().toLowerCase().replaceAll("\\W+", " ").split(" ");
        if (builder.toString().isEmpty()) {
            filtered = new String[0];
            return filtered;
        } else {
            for (String element : newArray) {
                if (element.startsWith(SPECIAL_CHARACTER)) {
                    newBuilder.append(element).append(" ");
                }
            }
        }
        if (newBuilder.toString().isEmpty()) {
            filtered = new String[0];
            return filtered;
        }
        filtered = newBuilder.toString().trim().split(" ");
        Arrays.sort(filtered);
        return filtered;
    }
}

