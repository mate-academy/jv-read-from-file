package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        ArrayList<String> wordsWithW = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String text = stringBuilder.toString().toLowerCase();
            String[] words = text.split("\\W+");
            for (String word : words) {
                if (word.startsWith("w")) {
                    wordsWithW.add(word);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read a file", e);
        }
        String[] arraysWithW = wordsWithW.toArray(new String[0]);
        Arrays.sort(arraysWithW);
        return arraysWithW;
    }
}
