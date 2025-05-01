package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilderFile = new StringBuilder();
        StringBuilder stringBuilderResult = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilderFile.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] arrayString = stringBuilderFile.toString().split("\\W+");
            for (String word : arrayString) {
                if (!word.isEmpty() && word.toLowerCase().toCharArray()[0] == 'w') {
                    stringBuilderResult.append(word.toLowerCase()).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found!", e);
        }
        if (stringBuilderResult.isEmpty()) {
            return new String[]{};
        } else {
            String[] result = stringBuilderResult.toString().split(" ");
            Arrays.sort(result);
            return result;
        }
    }
}
