package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private String[] result;

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] arrayString = stringBuilder.toString()
                    .replaceAll("[!.\n\r,?]", " ")
                    .toLowerCase().split(" ");

        StringBuilder stringBuilderForResult = new StringBuilder();
        if (stringBuilder.toString().isEmpty()) {
            return result = new String[0];
        } else {
            for (String s : arrayString) {
                if (s.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilderForResult.append(s).append(" ");
                }
            }
        }
        if (stringBuilderForResult.toString().isEmpty()) {
            return result = new String[0];
        }
        result = stringBuilderForResult.toString().trim().split(" ");
        Arrays.sort(result);
        return result;
    }
}
