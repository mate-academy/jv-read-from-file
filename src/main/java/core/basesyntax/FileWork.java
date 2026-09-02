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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string = bufferedReader.readLine();
            while (string != null) {
                builder.append(string).append(System.lineSeparator());
                string = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t open file");
        }
        if (builder.toString().equals("")) {
            return new String[0];
        }
        String[] split = builder.toString().split("\\W+");
        StringBuilder result = new StringBuilder();
        for (String string : split) {
            if (string.toLowerCase().charAt(0) == 'w') {
                result.append(string).append(" ");
            }
        }
        String[] resultArray;
        if (result.toString().equals("")) {
            return new String[0];
        }
        resultArray = result.toString().toLowerCase().split("\\W+");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
