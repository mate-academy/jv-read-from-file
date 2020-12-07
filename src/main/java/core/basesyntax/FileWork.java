package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder bufResult = new StringBuilder();
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                String[] wordsFromLine = lineFromFile.toLowerCase()
                        .replaceAll("[^a-z ]", "")
                        .split(" ");
                lineFromFile = bufferedReader.readLine();
                for (String word : wordsFromLine) {
                    if (word.startsWith(FIRST_LETTER_W)) {
                        bufResult.append(word).append(" ");
                    }
                }
            }
            result = bufResult.toString().split(" ");

        } catch (IOException e) {
            throw new RuntimeException("Can not read this file",e);
        }

        Arrays.sort(result);
        if (bufResult.toString().length() == 0) {
            return new String[0];
        }
        return result;
    }
}
