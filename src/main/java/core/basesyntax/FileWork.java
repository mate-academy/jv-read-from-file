package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int ZERO_INDEX = 0;

    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileLine = reader.readLine();
            while(fileLine != null) {
                String[] splitLine = fileLine.toLowerCase().split(" ");
                for (int i = 0; i < splitLine.length; i++) {
                    if ("w".equals(String.valueOf(splitLine[i].charAt(ZERO_INDEX)))) {
                        splitLine[i] = splitLine[i].replaceAll("\\W+", "");
                        builder.append(splitLine[i]).append(".");
                    }
                }
                fileLine = reader.readLine();
            }
            if (builder.toString().equals("")) {
                return new String[]{};
            } else {
                String[] finalArray = builder.toString().split("\\.");
                Arrays.sort(finalArray);
                return finalArray;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}


