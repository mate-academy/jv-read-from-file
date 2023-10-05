package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] words = new String[0];
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("[\\s\\p{Punct}]+");
                for (String word : lineWords) {
                    if (!word.isEmpty() && word.toLowerCase().charAt(0) == 'w') {
                        String[] newWords = new String[wordCount + 1];
                        System.arraycopy(words, 0, newWords, 0, wordCount);
                        newWords[wordCount] = word.toLowerCase();
                        words = newWords;
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < wordCount - 1; i++) {
            for (int j = 0; j < wordCount - i - 1; j++) {
                if (words[j].compareTo(words[j + 1]) > 0) {

                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
        return words;
    }
}
