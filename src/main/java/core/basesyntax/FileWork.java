package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here

        String[] arrayResult;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                String[] valueSplit = value.toLowerCase().split("\\W+");
                for (String valueStartsWith : valueSplit) {
                    if (valueStartsWith.startsWith("w")) {
                        builder.append(valueStartsWith).append(" ");
                    }
                }
                String readLine = reader.readLine();
                value = readLine != null ? readLine.toLowerCase() : null;
            }
            arrayResult = builder.toString().split(" ");
            if (arrayResult.length > 1) {
                String arrayToCompare;
                for (int j = 0; j < arrayResult.length; j++) {
                    for (int i = j + 1; i < arrayResult.length; i++) {
                        if (arrayResult[i].compareTo(arrayResult[j]) < 0) {
                            arrayToCompare = arrayResult[j];
                            arrayResult[j] = arrayResult[i];
                            arrayResult[i] = arrayToCompare;
                        }
                    }
                }
                return arrayResult;
            } else {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
