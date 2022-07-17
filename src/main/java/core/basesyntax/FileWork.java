package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                String[] line = reader.readLine().split("\\s");
                for (String word : line) {
                    if (word.charAt(0) == 'W' || word.charAt(0) == 'w') {
                        word = word.replaceAll("[^a-zA-Z]", "");
                        builder.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (builder.length() == 0) {
            return new String[0];
        }
        String[] wordsStartW = builder.toString().trim().split("\\s");
        System.out.println(wordsStartW.length);
        for (int i = 0; i < wordsStartW.length; i++) {
            wordsStartW[i] = wordsStartW[i].toLowerCase();
        }
        Arrays.sort(wordsStartW);
        return wordsStartW;
    }
}
