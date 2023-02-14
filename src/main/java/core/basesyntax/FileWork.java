package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String TARGET_REGEX = "w.*";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //write your code here
        return getNaturalySortedWords(stringBuilder);
    }

    private String[] getNaturalySortedWords(StringBuilder stringBuilder) {
        String[] words = stringBuilder.toString().toLowerCase().split("\\W");
        String[] targetWords = getTargetWords(words);
        sortWord(targetWords);
        return targetWords[0].equals("") ? new String[0] : targetWords;
    }

    private void sortWord(String[] targetWords) {
        for (int i = 0; i < targetWords.length; i++) {
            for (int j = i + 1; j < targetWords.length; j++) {
                String temp;
                if (targetWords[i].compareTo(targetWords[j]) > 0) {
                    temp = targetWords[i];
                    targetWords[i] = targetWords[j];
                    targetWords[j] = temp;
                }
            }
        }
    }

    private String[] getTargetWords(String[] words) {
        final String wordSeparator = " ";
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.matches(TARGET_REGEX)) {
                stringBuilder.append(word).append(wordSeparator);
            }
        }
        return stringBuilder.toString().split(wordSeparator);
    }
}
