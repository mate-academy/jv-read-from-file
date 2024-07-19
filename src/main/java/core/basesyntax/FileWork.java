package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        StringBuilder textFromFile = new StringBuilder();
        StringBuilder resultText = new StringBuilder();
        try (FileReader fileReader = new FileReader(myFile);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String value = reader.readLine();
            if (value == null || value.isEmpty()) {
                return new String[0];
            }
            while (value != null) {
                textFromFile.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            String[] words = textFromFile.toString().split("\\W+");
            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    resultText.append(word.toLowerCase()).append(System.lineSeparator());
                }
            }
            if (resultText.isEmpty()) {
                return new String[0];
            }
            String[] resultWords = resultText.toString().split(System.lineSeparator());
            Arrays.sort(resultWords);
            return resultWords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
