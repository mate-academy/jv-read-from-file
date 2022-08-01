package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value)
                        .append(" ");
                value = bufferedReader.readLine();
            }
            String arrString = builder.toString();
            if (arrString.trim().length() == 0) {
                return new String[0];
            }
            String[] words = arrString.split(" ");
            String resultW = "";
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    resultW += word.toLowerCase().replaceAll("[^A-Za-z]", "") + " ";
                }
            }
            if (resultW.length() == 0) {
                return new String[0];
            }
            String[] result = resultW.trim().split(" ");
            bufferedReader.close();
            Arrays.sort(result);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't reader file", e);
        } catch (IOException r) {
            throw new RuntimeException("Can't reader file", r);
        }
    }
}
