package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found!");
        }

        String[] split = stringBuilder.toString().split("\\W+");
        StringBuilder builder = new StringBuilder();
        if (stringBuilder.toString().equals("")) {
            return new String[0];
        }
        for (String word : split) {
            if (word.toLowerCase().charAt(0) == 'w') {
                builder.append(word.toLowerCase()).append(" ");
            }
        }
        if (builder.toString().equals("")) {
            return new String[0];
        }
        String[] arrayW = builder.toString().split(" ");
        Arrays.sort(arrayW);
        return arrayW;
    }

}
