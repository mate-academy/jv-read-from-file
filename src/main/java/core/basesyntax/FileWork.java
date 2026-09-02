package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] wordsWithW = new String[100];
        int index = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder fileText = new StringBuilder();
            String value = reader.readLine();

            while (value != null) {
                fileText.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            index = findWordsStartingWithW(fileText.toString(), wordsWithW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = new String[index];
        System.arraycopy(wordsWithW, 0, result, 0, index);
        Arrays.sort(result);
        return result;
    }

    private static int findWordsStartingWithW(String inputString, String[] wordsWithW) {
        int wordCounter = 0;
        String[] words = inputString.split("\\s+");
        for (String word : words) {
            word = word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
            if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                wordsWithW[wordCounter] = word.toLowerCase();
                wordCounter++;
            }
        }
        return wordCounter;
    }
}
