package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String stringFromFile = stringFromFile(fileName);
        String[] wordArray = stringFromFile.split("\\W+");
        int newArraySize = 0;
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordArray[i].toLowerCase();
            if (startWithLetter(wordArray[i])) {
                newArraySize += 1;
            }
        }

        String[] newWordArray = new String[newArraySize];
        int newArrayIndex = 0;
        for (String word : wordArray) {
            if (startWithLetter(word)) {
                newWordArray[newArrayIndex] = word;
                newArrayIndex += 1;
            }
        }
        Arrays.sort(newWordArray);
        return newWordArray;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    private String stringFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find a file " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file " + fileName, e);
        }
    }
}
