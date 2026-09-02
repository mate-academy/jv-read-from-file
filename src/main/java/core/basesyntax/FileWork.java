package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            String[] emptyArray = new String[0];
            if (value == null) {
                return emptyArray;
            }
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            value = stringBuilder.toString();
            String[] wordArray = value.split("\\W+");
            String[] words = new String[wordArray.length];
            String onlyWWords = new String("");
            String[] firstLetters = new String[wordArray.length];
            for (int i = 0; i < wordArray.length; i++) {
                words[i] = wordArray[i].toLowerCase();
                firstLetters[i] = Character.toString(words[i].charAt(0));
                if (firstLetters[i].equals("w")) {
                    onlyWWords += words[i] + " ";
                }
            }
            if (onlyWWords.equals("")) {
                return emptyArray;
            } else {
                String[] result = onlyWWords.split(" ");
                Arrays.sort(result);
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException(e + " Can't read file: " + fileName);
        }
    }
}
