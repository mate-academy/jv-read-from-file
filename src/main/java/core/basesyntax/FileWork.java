package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String[] wordsStartsWithW;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                text.append(br.readLine()).append(" ");
            }
            String textWithoutPunctuation = text.toString().toLowerCase()
                    .replaceAll("[^\\w\\s]+", " ");
            String[] array = textWithoutPunctuation.split(" ");
            for (String s : array) {
                if (s.startsWith("w")) {
                    result.append(" ").append(s);
                }
            }
            wordsStartsWithW = result.toString().trim().split(" ");
            if (wordsStartsWithW.length == 1 && wordsStartsWithW[0].isEmpty()) {
                return new String[0];
            }
            Arrays.sort(wordsStartsWithW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordsStartsWithW;
    }
}
