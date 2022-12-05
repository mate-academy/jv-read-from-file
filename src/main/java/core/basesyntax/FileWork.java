package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        String fileData = readFile(fileName);

        if (fileData.isEmpty()) {
            return new String[] {};
        }

        String filteredWords = filterWords(fileData);

        if (filteredWords.isEmpty()) {
            return new String[] {};
        }

        String[] resultArray = filteredWords.split(",");
        Arrays.sort(resultArray);
        Arrays.toString(resultArray);

        return resultArray;
    }

    private String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't open file " + fileName, e);
        }

        return stringBuilder.toString();
    }

    private String filterWords(String data) {
        String[] words = data.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word: words) {
            if (word.toLowerCase().startsWith("w")) {
                stringBuilder.append(word.toLowerCase()).append(",");
            }
        }
        return stringBuilder.toString();
    }
}

