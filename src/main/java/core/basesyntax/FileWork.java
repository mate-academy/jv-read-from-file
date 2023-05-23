package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while ((value != -1)) {
                stringBuilder.append((char)value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName,e);
        }
        String readedString = stringBuilder.toString().toLowerCase();
        if (readedString.length() == 0) {
            return new String[0];
        }
        String[] wordsArr = readedString.split("[^a-zA-Z'-]+");
        int lengthOutArr = 0;
        for (String word:wordsArr) {
            if (word.charAt(0) == 'w') {
                lengthOutArr++;
            }
        }
        String[] outputArr = new String[lengthOutArr];
        int i = 0;
        for (String word:wordsArr) {
            if (word.charAt(0) == 'w') {
                outputArr[i] = word;
                i++;
            }
        }
        Arrays.sort(outputArr);
        return outputArr;
    }
}
