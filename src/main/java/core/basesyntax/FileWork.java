package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        return this.readFromFile(fileName,'w');
    }

    public String[] readFromFile(String fileName, char firstLetter) {
        File file = new File(fileName);
        StringJoiner joiner = new StringJoiner(" ");

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (final String word : words) {
                    String lowercaseString = word.toLowerCase();
                    if (lowercaseString.charAt(0) == firstLetter) {
                        String normalizeString = lowercaseString.replaceAll("[^a-zA-Z0-9]", "");
                        joiner.add(normalizeString);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        if (joiner.length() > 0) {
            String[] resultWords = joiner.toString().split(" ");
            for (int i = 0; i < resultWords.length - 1; i++) {
                for (int j = i + 1; j < resultWords.length; j++) {
                    if (resultWords[i].compareTo(resultWords[j]) > 0) {
                        String temp = resultWords[i];
                        resultWords[i] = resultWords[j];
                        resultWords[j] = temp;
                    }
                }
            }
            return resultWords;
        } else {
            return new String[0];
        }
    }
}
