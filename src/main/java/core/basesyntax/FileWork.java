package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String fileLine = reader.readLine();
            while (fileLine != null) {
                String[] lineSplitLower = fileLine.toLowerCase().split(" ");
                for (int i = 0; i < fileLine.length(); i++) {
                    if("w".equals(String.valueOf(lineSplitLower[i].charAt(0)))){
                        lineSplitLower[i] = lineSplitLower[i].replaceAll("\\W+", "");
                        builder.append(lineSplitLower[i]).append(".");
                    }
                }
                fileLine = reader.readLine();
            }
            if (builder.toString().equals("")) {
                return new String[]{};
            } else {
                String[] array = builder.toString().split("\\.");
                Arrays.sort(array);
                return  array;
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
    }
}
