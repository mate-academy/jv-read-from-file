package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        list.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot open file", e);
        }

        String[] resultArray = list.toArray(new String[0]);
        Arrays.sort(resultArray);
        return resultArray;
    }
}
