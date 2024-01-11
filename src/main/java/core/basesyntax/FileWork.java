package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    private StringBuilder stringBuilder = new StringBuilder();
    private List<String> result = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] line = value.split(" ");
                value = bufferedReader.readLine();
                for (int i = 0; i < line.length; i++) {
                    if (line[i].startsWith("w") || line[i].startsWith("W")) {
                        line[i].toLowerCase();
                        result.add(line[i].toLowerCase().replaceAll("[^a-zA-Z[wW]]", ""));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Collections.sort(result);
        String[] finalArray = new String[result.size()];
        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = result.get(i);
        }
        return finalArray;
    }
}
