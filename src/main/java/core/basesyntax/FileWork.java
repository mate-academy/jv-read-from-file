package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String REGEX_FOR_SPLITTING = "\\W+";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value.toLowerCase()).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] split = builder.toString().split(REGEX_FOR_SPLITTING);
        int sizeOfArray = 0;
        for (String element : split) {
            if (element.startsWith(SPECIFIED_CHARACTER)) {
                sizeOfArray++;
            }
        }
        String[] array = new String[sizeOfArray];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < split.length; j++) {
                if (split[j].startsWith(SPECIFIED_CHARACTER)) {
                    array[i] = split[j];
                    i++;
                }
            }
        }
        if (array.length != 0) {
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
