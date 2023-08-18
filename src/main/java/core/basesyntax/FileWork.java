package core.basesyntax;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private static String needed_Letter = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] allWords = stringBuilder.toString().toLowerCase().split("\\W+");
        stringBuilder.setLength(0);
        for (String word:allWords) {
            if (word.startsWith(needed_Letter)) {
                stringBuilder.append(word).append(" ");
            }
        }
        String[] wordsInOrder = stringBuilder.toString().split(" ");
        Arrays.sort(wordsInOrder, Comparator.naturalOrder());
        return wordsInOrder.length > 1 ? wordsInOrder : new String[0];
    }
}
