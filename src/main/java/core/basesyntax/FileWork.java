package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String wordsArray = stringBuilder.toString();
        String[] splitter = wordsArray.split(" ");
        StringBuilder passingWords = new StringBuilder();
        for (String word : splitter) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (chars[0] == 'W' || chars[0] == 'w') {
                    if ((chars[i] >= 'a' && chars[i] <= 'z')
                            || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                        passingWords.append(chars[i]);
                    }
                }
                if ((chars[0] == 'w' || chars[0] == 'W') && i == word.length() - 1) {
                    passingWords.append(" ");
                }
            }
        }
        String[] output = passingWords.toString().toLowerCase().split(" ");
        Arrays.sort(output);
        if (passingWords.toString().isEmpty()) {
            return new String[0];
        }
        return output;
    }
}
