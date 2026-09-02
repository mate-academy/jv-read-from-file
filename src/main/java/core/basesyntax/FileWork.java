package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int CHAR_ZERO = 0;

    public String[] readFromFile(String fileName) {
        StringBuilder sentence = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                sentence.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }

        String clearSentences = sentence.toString().toLowerCase().replaceAll("\n", " ")
                .replaceAll("[^a-z ]", "");
        String[] splitSentence = clearSentences.split(" ");
        int countWords = 0;
        if (sentence.toString().length() > 0) {
            for (String word : splitSentence) {
                if (word.charAt(CHAR_ZERO) == 'w') {
                    countWords++;
                }
            }
        }
        int wordPosition = 0;
        String[] result = new String[countWords];
        if (sentence.toString().length() > 0) {
            for (String word : splitSentence) {
                if (word.charAt(CHAR_ZERO) == 'w') {
                    result[wordPosition] = word;
                    wordPosition++;
                }
            }
        }

        Arrays.sort(result);
        return result;
    }
}
