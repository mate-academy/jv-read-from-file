package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] words = readFile(fileName).split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        String[] sortedWords;
        for (String word: words) {
            if (word.toLowerCase().indexOf("w") == 0) {
                stringBuilder.append(word.toLowerCase()).append(System.lineSeparator());
            }
        }
        sortedWords = stringBuilder.toString().split(System.lineSeparator());
        Arrays.sort(sortedWords);
        return stringBuilder.toString().equals("") ? new String[0] : sortedWords;
    }

    public String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String stringFromFile;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringFromFile = bufferedReader.readLine();
            while (stringFromFile != null) {
                stringBuilder.append(stringFromFile).append(" ");
                stringFromFile = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("The file at path" + fileName + " was not read : " + e);
        }
        return stringBuilder.toString();
    }
}
