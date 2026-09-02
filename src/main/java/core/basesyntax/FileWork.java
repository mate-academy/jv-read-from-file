package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        char targetLetter = 'w';
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value;
            while ((value = reader.readLine()) != null) {
                stringBuilder.append(value).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String fileContent = stringBuilder.toString().toLowerCase();
        String[] arrayOfWords = fileContent.split("\\s+");
        int count = 0;
        for (String word : arrayOfWords) {
            if (word.toLowerCase().startsWith(String.valueOf(targetLetter))) {
                count++;
            }
        }
        String[] resultArray = new String[count];
        int index = 0;
        for (String word : arrayOfWords) {
            if (word.toLowerCase().startsWith(String.valueOf(targetLetter))) {
                while (word.length() > 0 && !Character.isLetter(word.charAt(word.length() - 1))) {
                    word = word.substring(0, word.length() - 1);
                }
                resultArray[index++] = word;
            }
        }
        Arrays.sort(resultArray);
        return resultArray;
    }
}
