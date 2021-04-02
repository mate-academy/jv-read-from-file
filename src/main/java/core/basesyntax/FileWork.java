package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] changeValue;
        String[] fileRead = {};
        File myFile = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                changeValue = (value.replaceAll("\\W+", " ")
                        .toLowerCase().split(" "));
                for (int i = 0; i < changeValue.length; i++) {
                    if (changeValue[i].charAt(0) == 'w') {
                        builder.append(changeValue[i]).append(" ");
                    }
                }
                value = reader.readLine();
            }
            if (builder.length() == 0) {
                return fileRead;
            }
            fileRead = String.valueOf(builder).split(" ");
            Arrays.sort(fileRead);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }
        return fileRead;
    }
}
