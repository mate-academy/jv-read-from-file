package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String REGEX = "[\\s\\p{Punct}]+";
    private static final String FIRST_KEY_WORD = "w";
    private static final String SECOND_KEY_WORD = "W";
    private static final String EMPTY_SPACE = " ";

    public String[] readFromFile(String fileName) {

        String result = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split(REGEX);
                for (String word : splittedLine) {
                    if (word == null || word.isEmpty()) {
                        continue;
                    }
                    if (word.substring(0,1).equals(FIRST_KEY_WORD)
                            || word.substring(0,1).equals(SECOND_KEY_WORD)) {
                        result += word.toLowerCase() + EMPTY_SPACE;
                    }
                }
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (result.isEmpty()) {
            return new String[0];
        }

        String[] finalResult = result.split(EMPTY_SPACE);
        Arrays.sort(finalResult);

        return finalResult;
    }
}
