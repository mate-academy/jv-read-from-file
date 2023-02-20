package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FileWork {
    private static final String REGEX_FOR_SPLITTING = "\\W+";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value.toLowerCase(Locale.ROOT)).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        String[] arr = builder.toString().split(REGEX_FOR_SPLITTING);
        int sizeOfArray = 0;
        for (String element : arr) {
            if (element.startsWith("w")) {
                sizeOfArray++;
            }
        }
        String[] result = new String[sizeOfArray];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].startsWith(SPECIFIED_CHARACTER)) {
                    result[i] = arr[j];
                    i++;
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String e : result) {
            list.add(e);
        }
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
}
