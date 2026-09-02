package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String sentence;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            sentence = stringBuilder.toString().toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] separate = sentence.split("\\W+");
        if (sentence.isEmpty()) {
            return EMPTY_STRING_ARRAY;
        }
        StringBuilder wordsW = new StringBuilder();
        for (String value : separate) {
            if (value.charAt(0) == 'w') {
                wordsW.append(value).append(" ");
            }
        }
        String sentenceWithWordsOfW = wordsW.toString();
        String[] arrayWordsWithW = sentenceWithWordsOfW.split(" ");
        Arrays.sort(arrayWordsWithW);
        if (sentenceWithWordsOfW.isEmpty()) {
            return EMPTY_STRING_ARRAY;
        }
        return arrayWordsWithW;
    }
}
