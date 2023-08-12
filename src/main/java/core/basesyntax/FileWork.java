package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String DESIRED_LETTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> dynamicArray = new ArrayList<>();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(" ").append(value);
                value = reader.readLine();
            }
            String[] split = stringBuilder.toString().split("\\W+");
            for (String result : split) {
                if (result.toLowerCase().startsWith(DESIRED_LETTER)) {
                    dynamicArray.add(result.toLowerCase());
                }
            }
            Collections.sort(dynamicArray);
            return dynamicArray.toArray(new String[dynamicArray.size()]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file ");
        }
    }
}
