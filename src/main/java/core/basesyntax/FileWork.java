package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String text = new String();
        try (BufferedReader bufferedReader =
                new BufferedReader(new FileReader(new File(fileName)))) {
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                text += (char) symbol;
                symbol = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        String[] result = findWordsStartsWith(text, "w");
        return result;
    }

    public String[] findWordsStartsWith(String text, String startLetter) {
        String[] words = text.replaceAll("\\p{Punct}", "").split("\\s");
        int wordsAmount = 0;
        for (String word : words) {
            if (word.startsWith(startLetter.toLowerCase())
                    || word.startsWith(startLetter.toUpperCase())) {
                wordsAmount++;
            }
        }

        String[] result = new String[wordsAmount];
        int index = 0;
        for (String word : words) {
            if (word.startsWith(startLetter.toLowerCase())
                    || word.startsWith(startLetter.toUpperCase())) {
                result[index] = word.toLowerCase();
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
