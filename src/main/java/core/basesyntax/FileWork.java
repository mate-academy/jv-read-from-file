package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder textFromFile = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String index = bufferedReader.readLine();
            while (index != null) {
                textFromFile.append(index).append(" ");
                index = bufferedReader.readLine();
            }
        } catch (IOException e) {
            return new String[0];
        }
        if (textFromFile.isEmpty()) {
            return new String[0];
        }

        String regex = "[,\\.\\s\\!\\?]";
        String[] splitText = textFromFile.toString().toLowerCase().split(regex);
        StringBuilder wordsWithW = new StringBuilder();
        for (String word : splitText) {
            if (word == "") {
                continue;
            }
            if (word.charAt(0) == 'w') {
                wordsWithW.append(word).append(" ");
            }
        }
        if (wordsWithW.isEmpty()) {
            return new String[0];
        }
        String[] result = wordsWithW.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
