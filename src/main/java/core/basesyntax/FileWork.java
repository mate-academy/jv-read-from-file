package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words;
        String[] wordsWithW;
        int size = 0;
        int index = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                stringBuilder.append((char) symbol);
                symbol = bufferedReader.read();
            }
            words = stringBuilder.toString().toLowerCase().split("\\W+");
            Arrays.sort(words);
            for (String word : words) {
                if (word.startsWith("w")) {
                    size++;
                }
            }
            wordsWithW = new String[size];
            for (String word : words) {
                if (word.startsWith("w")) {
                    wordsWithW[index] = word;
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't create file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return wordsWithW;
    }
}
