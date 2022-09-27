package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String PREFIX = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String readFile = bufferedReader.readLine();
            while (readFile != null) {
                stringBuilder.append(readFile).append(" ");
                readFile = bufferedReader.readLine();
            }
            String dataOfReadFile = stringBuilder.toString().toLowerCase();
            StringBuilder builder = new StringBuilder();
            String[]newArray = dataOfReadFile.split("\\W+");
            for (String word : newArray) {
                if (word.startsWith(PREFIX)) {
                    builder.append(word).append(" ");
                }
            }
            String result = builder.toString();
            if (result.length() == 0) {
                return new String[]{};
            } else {
                String[] outputs = result.split(" ");
                Arrays.sort(outputs);
                return outputs;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}
