package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String data = readData(fileName);
        String[] dataArray = data.split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (String word : dataArray) {
            if (word.startsWith("w") || word.startsWith("W")) {
                builder.append(word.toLowerCase()).append(" ");
            }
        }
        String resultString = builder.toString().trim();
        if (resultString.isEmpty()) {
            return new String[0];
        }
        String[] result = resultString.split(" ");
        Arrays.sort(result);
        return result;
    }

    private String readData(String fileName) {
        StringBuilder textFromFileBuilder = new StringBuilder();
        String value;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            value = bufferedReader.readLine();
            while (value != null) {
                textFromFileBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
        return textFromFileBuilder.toString();
    }
}
