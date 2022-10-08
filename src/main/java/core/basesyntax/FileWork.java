package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String data = reader.readLine();
            if (data == null) {
                return new String[0];
            } else {
                while (data != null) {
                    builder.append(data).append(" ");
                    data = reader.readLine();
                }
                String[] splittedData = builder.toString().toLowerCase().split("\\W+");
                System.out.println(Arrays.toString(splittedData));
                StringBuilder resultBuilder = new StringBuilder();
                for (String word : splittedData) {
                    if (word.startsWith("w")) {
                        resultBuilder.append(word).append(System.lineSeparator());
                    }
                }
                System.out.println(resultBuilder);
                String[] resultArray = resultBuilder.toString().split(System.lineSeparator());
                Arrays.sort(resultArray);
                System.out.println(Arrays.toString(resultArray));
                if (resultArray.length == 1 && resultArray[0].isEmpty()) {
                    return new String[0];
                } else {
                    return resultArray;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read the file", e);
        }
    }
}



