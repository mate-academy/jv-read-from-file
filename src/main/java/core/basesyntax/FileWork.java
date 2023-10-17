package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> resultArray = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\W+");
                for (String string : split) {
                    if (string.toLowerCase().startsWith("w")) {
                        resultArray.add(string.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t open the file", e);
        }
        resultArray.sort(Comparator.naturalOrder());
        System.out.println(resultArray);
        return resultArray.toArray(new String[0]);
    }
}
