package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_SYMBOL = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder = new StringBuilder();
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                stringBuilder.append(value).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        String[] resultArray = stringBuilder.toString().toLowerCase().split("\\W+");
        StringBuilder newSB = new StringBuilder();
        for (String res:resultArray) {
            if (res.startsWith(FIRST_SYMBOL)) {
                newSB.append(res).append(" ");
            }
        }
        if (newSB.length() == 0) {
            return new String[0];
        }
        String [] finalResult = newSB.toString().split(" ");
        Arrays.sort(finalResult);
        return finalResult;
    }
}
