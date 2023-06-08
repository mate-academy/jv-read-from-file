package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> listString = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] values = value.toLowerCase().split("\\W+");
                for (String word : values) {
                    if (word.startsWith("w")) {
                        listString.add(word);
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file", e);
        }
        String [] result = listString.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
