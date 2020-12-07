package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_SYMBOL = "w";

    public String[] readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close BufferedReader",e);
                }
            }
        }
        String[] resultArray = stringBuilder.toString().toLowerCase().split("\\s+");
        StringBuilder newSB = new StringBuilder();
        for (String res:resultArray) {
            if (res.startsWith(FIRST_SYMBOL)) {
                res = res.replaceAll("[!?.,]", "");
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
