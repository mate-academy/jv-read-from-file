package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WHITESPACE = " ";
    private static final String NOTWORD = "\\W+";
    private StringBuilder builderWordsW = new StringBuilder();
    private StringBuilder builderWordsAll = new StringBuilder();
    private int count = 0;

    public String[] readFromFile(String fileName) {
        if ((fileName == "") || (fileName == null)) {
            return null;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                builderWordsAll.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] words = builderWordsAll.toString().toLowerCase().split(NOTWORD);
        for (int i = 0; i < words.length; i++) {
            if ((words[i].length() >= 1) && (words[i].charAt(0) == ('w'))) {
                builderWordsW.append(words[i] + " ");
                count += 1;
            } else if (i == words.length - 1 && count == 0) {
                return new String[0];
            }
        }
        String[] wordsW = builderWordsW.toString().split(WHITESPACE);
        Arrays.sort(wordsW);
        return wordsW;
    }
}
