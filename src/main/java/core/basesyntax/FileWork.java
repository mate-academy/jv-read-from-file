package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String[] emptyArray = new String[]{};
    public static final int ZERO_LENGTH = 0;
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            if (file.length() == ZERO_LENGTH) {
                return emptyArray;
            }
            builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append((value) + " ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileAsString = builder.toString().replaceAll("[!.,?]","").toLowerCase();
        String[] fileAsStringArray = fileAsString.split(" ");
        StringBuilder result = new StringBuilder();
        int countWords = 0;
        for (String element : fileAsStringArray) {
            if (element.startsWith(SPECIFIED_CHARACTER)) {
                result.append(element + " ");
                countWords++;
            }
        }
        if (countWords == 0) {
            return emptyArray;
        }
        String[] resultAsArray = result.toString().split(" ");
        Arrays.sort(resultAsArray);

        return resultAsArray;
    }
}
