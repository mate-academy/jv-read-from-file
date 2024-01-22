package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String textFromFile = stringFromFile(fileName);
        if (textFromFile.length() == 0) {
            return new String[]{};
        }

        String[] arrayString = textFromFile.split("\\W+");
        int size = 0;
        for (String word : arrayString) {
            if (word.startsWith("w") || word.startsWith("W")) {
                size++;
            }
        }
        String[] resultArray = new String[size];
        int indexInResultArray = 0;
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].startsWith("w") || arrayString[i].startsWith("W")) {
                resultArray[indexInResultArray++] = arrayString[i].toLowerCase();
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }

    public String stringFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String resultString = bufferedReader.readLine();
            while (resultString != null) {
                builder.append(resultString).append(System.lineSeparator());
                resultString = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName);
        }
        return builder.toString();
    }
}
