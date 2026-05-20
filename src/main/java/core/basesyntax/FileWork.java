package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                str.append((char) value);
                value = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        if (str.isEmpty()) {
            return new String[0];
        }
        String cleanText = str.toString().toLowerCase().replaceAll("\\p{Punct}", "");
        String[] words = cleanText.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty() && word.charAt(0) == 'w') {
                count++;
            }
        }
        String[] wordW = new String[count];
        int index = 0;
        for (String word : words) {
            if (!word.isEmpty() && word.charAt(0) == 'w') {
                wordW[index++] = word;
            }
        }
        Arrays.sort(wordW, Collator.getInstance());
        return wordW;
    }

    public static void main(String[] args) {
        FileWork work = new FileWork();
        System.out.println(Arrays.toString(work.readFromFile("test4")));
    }
}

