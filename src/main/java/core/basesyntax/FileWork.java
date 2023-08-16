package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String UPPER_SPECIAL_CHAR = "W";
    private static final String LOWER_SPECIAL_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split("\\W+");
                for (String string : strings) {
                    if (string.startsWith(UPPER_SPECIAL_CHAR)
                            || string.startsWith(LOWER_SPECIAL_CHAR)) {
                        stringBuilder.append(string.toLowerCase()).append(" ");
                    }
                }
            }
            bufferedReader.close();
            BufferedReader bufferedReaderCheck = new BufferedReader(new FileReader(file));
            if (bufferedReaderCheck.readLine() == null || stringBuilder.toString().equals("")) {
                return new String[0];
            }
            bufferedReaderCheck.close();
            String[] result = stringBuilder.toString().split(" ");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
