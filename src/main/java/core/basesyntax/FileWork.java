package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static int lengthResultArray = 0;

    public String[] readFromFile(String fileName) {
        String textFile = readFile(fileName);
        if (textFile.isEmpty()) {
            return new String[0];
        }
        String[] splitText = textFile.split("\\W+");
        for (String word : splitText) {
            char firstChar = word.toLowerCase().charAt(0);
            if (firstChar == 'w') {
                lengthResultArray++;
            }
        }
        String[] resultArray = new String[lengthResultArray];
        for (String word : splitText) {
            char firstChar = word.toLowerCase().charAt(0);
            if (firstChar == 'w') {
                resultArray[lengthResultArray - 1] = word.toLowerCase();
                lengthResultArray--;
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }

    private String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find file.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file.", e);
        }
        return stringBuilder.toString();
    }
}
