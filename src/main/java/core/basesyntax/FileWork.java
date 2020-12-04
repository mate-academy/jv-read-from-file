package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            List<String> arrayList = new ArrayList<>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(" ");
                for (String s : split) {
                    if (s.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        arrayList.add(s.replaceAll("\\W", "").toLowerCase());
                    }
                }
            }
            String[] resultArray = arrayList.toArray(new String[arrayList.size()]);
            Arrays.sort(resultArray);
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("");
        }
    }
}
