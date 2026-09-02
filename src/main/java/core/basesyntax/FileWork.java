package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        String[] words;
        ArrayList<String> wordsWithW = new ArrayList<>();
        File file = new File(fileName);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close BufferedReader");
                }
            }
        }
        if (stringBuilder.length() != 0) {
            words = stringBuilder.toString().toLowerCase().split("\\W+");
            for (String word : words) {
                if (word.charAt(0) == SPECIFIED_CHARACTER) {
                    wordsWithW.add(word);
                }
            }
        }
        Collections.sort(wordsWithW);
        return wordsWithW.toArray(new String[0]);
    }
}
