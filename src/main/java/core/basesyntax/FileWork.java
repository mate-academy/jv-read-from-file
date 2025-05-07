package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] tekLine = line.toLowerCase().split("\\W+");
                for (String tekWord : tekLine) {
                    if (tekWord.substring(0, 1).equals("w")) {
                        stringBuilder.append(tekWord).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Errors while reading file", e);
        }
        if (stringBuilder.toString().length() == 0) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
