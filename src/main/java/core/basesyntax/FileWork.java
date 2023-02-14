package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            if (value == null) {
                return new String [0];
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        String[] split = stringBuilder.toString().toLowerCase().split("\\W+");
        Arrays.sort(split);
        int count = 0;
        for (String word : split) {
            if (word.charAt(0) == 'w') {
                count++;
            }
        }
        String [] wordsWithLetter = new String[count];
        int i = 0;
        for (String word : split) {
            if (word.charAt(0) == 'w') {
                wordsWithLetter [i] = word;
                i++;
            }
        }
        return wordsWithLetter;
    }
}
