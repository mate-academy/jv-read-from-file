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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file!", e);
        }
        String text = stringBuilder.toString();
        String[] textInFile = text.split(" ");
        StringBuilder wordsWithFirstW = new StringBuilder();
        for (String word : textInFile) {
            char[] wordInChar = word.toCharArray();
            for (int i = 0;i < word.length();i++) {
                if (wordInChar[0] == 'w' || wordInChar[0] == 'W') {
                    if ((wordInChar[i] >= 'a' && wordInChar[i] <= 'z')
                            || (wordInChar[i] >= 'A' && wordInChar[i] <= 'Z')) {
                        wordsWithFirstW.append(wordInChar[i]);
                    }
                }
                if ((wordInChar[0] == 'w' || wordInChar[0] == 'W')
                        && i == word.length() - 1) {
                    wordsWithFirstW.append(" ");
                }
            }
        }
        if (wordsWithFirstW.toString().isEmpty()) {
            return new String[0];
        }
        String[] wwords = wordsWithFirstW.toString().toLowerCase().split(" ");
        Arrays.sort(wwords);
        return wwords;
    }
}
