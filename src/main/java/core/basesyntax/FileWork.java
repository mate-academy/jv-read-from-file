package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder data = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                data.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!" + fileName, e);
        }
        String[] stringArrayData = data.toString().split("\\W++");
        StringBuilder stringResult = new StringBuilder();
        for (String word : stringArrayData) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                stringResult.append(word.toLowerCase()).append(",");
            }
        }
        if (stringResult.toString().equals("")) {
            return new String[0];
        }

        String[] result = stringResult.toString().split("\\W++");
        Arrays.sort(result);
        return result;
    }

}
