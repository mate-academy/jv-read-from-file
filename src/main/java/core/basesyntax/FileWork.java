package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final int FIRST_BOUNDARY = 0;
    public static final int SECOND_BOUNDARY = 1;

    public String[] readFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String tempString = reader.readLine();
            while (tempString != null) {
                builder.append(tempString).append(" ");
                tempString = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file", e);
        }

        String[] filterdStrings = builder.toString().toLowerCase().split("\\W+");

        builder = new StringBuilder();
        for (String filteredString : filterdStrings) {
            if (!filteredString.isEmpty()) {
                String letter = filteredString.substring(FIRST_BOUNDARY, SECOND_BOUNDARY);
                if (letter.equals("w")) {
                    builder.append(filteredString).append(" ");
                }
            }
        }

        String[] sortingString = builder.toString().split(" ");

        if (!sortingString[0].isEmpty()) {
            Arrays.sort(sortingString);
            return sortingString;
        } else {
            return new String[]{};
        }
    }
}
