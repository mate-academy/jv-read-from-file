package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                String[] sensenses = value.split("\\W+");
                for (String word : sensenses) {
                    if (word.toLowerCase().startsWith("w")) {
                        builder.append(word.toLowerCase())
                                .append(" ");
                    }
                }
                value = bufferedReader.readLine();
            }
            bufferedReader.close();
            if (builder.length() == 0) {
                return new String[0];
            }
            String[] result = builder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't' read this file", e);
        }

    }
}
