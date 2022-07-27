package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();

        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file", e);
        }
        String[] wordsSplitArray = stringBuilder.toString().toLowerCase().split("\\W+");
        int counter = 0;
        for (int i = 0; i < wordsSplitArray.length; i++) {
            if (wordsSplitArray[i].startsWith("w")) {
                counter++;
                result.append(wordsSplitArray[i]).append(",");
            }
        }
        if (counter == 0) {
            return new String[0];
        }
        String[] resultW = result.toString().split("\\W+");
        Arrays.sort(resultW);
        return resultW;
    }
}
