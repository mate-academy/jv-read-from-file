package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {

    private static final char LOWER_DESIRED_LETTER = 'w';
    private static final char UPPER_DESIRED_LETTER = 'W';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder words = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            findWordsWithW(lines, words);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] finalResult = getWordArray(words.toString());
        if (finalResult.length == 1 && finalResult[0].equals("")) {
            return new String[0];
        }
        return getWordArray(words.toString());
    }

    private String[] getWordArray(String words) {
        words = words.toLowerCase();
        String[] wordArray = words.split(" ");
        Arrays.sort(wordArray);
        return wordArray;
    }

    private void findWordsWithW(List<String> lines, StringBuilder words) {
        for (String line : lines) {
            String[] splitLines = line.split(" ");
            for (String splitLine : splitLines) {
                char[] letters = splitLine.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    if (!(i == 0 && (letters[i] == LOWER_DESIRED_LETTER
                            || letters[i] == UPPER_DESIRED_LETTER))) {
                        break;
                    }
                    StringBuilder word = new StringBuilder();
                    for (char letter : letters) {
                        if (letter > 64 && letter < 91 || letter > 96 && letter < 123) {
                            word.append(letter);
                        }
                    }
                    if (!words.toString().equals("")) {
                        words.append(" ");
                    }
                    words.append(word);
                }
            }
        }
    }
}
