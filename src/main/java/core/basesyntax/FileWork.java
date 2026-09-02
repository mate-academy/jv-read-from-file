package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String [] wordsFromText;
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value);
                builder.append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName + e);
        }
        String textFromFile = builder.toString();
        wordsFromText = textFromFile.split("\\W+");
        builder = new StringBuilder();
        for (String s : wordsFromText) {
            if (s.toLowerCase().charAt(0) == 'w') {
                builder.append(s.toLowerCase());
                builder.append(" ");
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[0];
        }
        String [] wordStartsWithW = builder.toString().split(" ");
        Arrays.sort(wordStartsWithW);
        return wordStartsWithW;
    }
}
