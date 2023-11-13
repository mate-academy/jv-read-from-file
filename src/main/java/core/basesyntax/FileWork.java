package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line.toLowerCase()).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            String fileInfo = stringBuilder.toString();
            String[] words = fileInfo.split("\\W+");
            int resultSize = 0;
            for (String word : words) {
                if (word.startsWith("w")) {
                    resultSize++;
                }
            }
            String[] result = new String[resultSize--];
            for (String word : words) {
                if (word.startsWith("w")) {
                    result[resultSize] = word;
                    resultSize--;
                }
            }
            for (int i = 0; i < result.length - 1; i++) {
                for (int j = 0; j < result.length - i - 1; j++) {
                    if (result[j].compareTo(result[j + 1]) > 0) {
                        String temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                    }
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read line from file", e);
        }
    }
}
