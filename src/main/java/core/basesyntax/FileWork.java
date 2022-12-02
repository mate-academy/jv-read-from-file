package core.basesyntax;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        int indexCounter = 0;
        int counter = 0;
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        String[] sortedWords;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while (value != null) {
                value = reader.readLine();
                stringBuilder.append(value).append(System.lineSeparator());
            }
            String wordsFromFile = stringBuilder.toString();
            String[] splitted = wordsFromFile.split("\\W+");
            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].charAt(0) == 'w') {
                    counter++;
                }
            }
            sortedWords = new String[counter];
            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].charAt(0) == 'w') {
                    sortedWords[indexCounter] = splitted[i];
                    indexCounter++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return sortedWords;
    }
}
