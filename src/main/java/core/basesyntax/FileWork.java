package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SEPARATOR = " ";
    private static final String[] EMPTY_ARRAY_RESULT = new String[0];

    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            if (value == -1) {
                return EMPTY_ARRAY_RESULT;
            }
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not found", e);
        }

        String[] array = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder stringBuilder1 = new StringBuilder();

        for (String element : array) {
            if (element.startsWith(SPECIFIED_CHARACTER)) {
                stringBuilder1.append(element.toLowerCase()).append(SEPARATOR);
            }
        }

        String[] a = stringBuilder1.toString().split(" ");
        Arrays.sort(a);
        if (a.length == 1) {
            return EMPTY_ARRAY_RESULT;
        } else {
            return a;
        }
    }
}

