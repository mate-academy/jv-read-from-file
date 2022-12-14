package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder firstBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                firstBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't reaad this file", e);
        }
        if (firstBuilder.toString().length() == 0) {
            return new String[0];
        }
        String textFile = firstBuilder.toString().toLowerCase();
        String [] splitResult = textFile.split("\\W+");
        StringBuilder secondBuilder = new StringBuilder();
        for (String splitter: splitResult) {
            if (splitter.charAt(0) == 'w') {
                secondBuilder.append(splitter).append(" ");
            }
        }
        String [] result = secondBuilder.toString().split(" ");
        Arrays.sort(result);
        return (secondBuilder.toString().length() == 0) ? new String[0] : result;
    }
}
