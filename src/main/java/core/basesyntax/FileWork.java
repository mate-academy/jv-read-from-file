package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> result = new ArrayList<>();
        for (String el : lines) {
            String[] words = el.split(" ");
            for (String elWords : words) {
                String wordsToLowerCase = elWords.toLowerCase();
                char[] charWordsToLowerCase = wordsToLowerCase.toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                String clearWord = "";
                for (char ch : charWordsToLowerCase) {
                    if (Character.isLetter(ch)) {
                        clearWord = stringBuilder.append(ch).toString();
                    }
                }
                if (clearWord.startsWith("w")) {
                    result.add(clearWord);
                }
            }
        }
        String[] arr = result.toArray(new String[0]);
        Arrays.sort(arr);
        return arr;
    }
}
