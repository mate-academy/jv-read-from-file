package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String NON_LETTERS_AND_SPACE_REGEX = "[^A-Za-z ]+";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileReader fileRider = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileRider)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] words = line.replaceAll(NON_LETTERS_AND_SPACE_REGEX, "")
                        .toLowerCase()
                        .split(" ");

                for (String word: words) {
                    if (!startWithLetter(word)) {
                        continue;
                    }

                    stringBuilder.append(word).append(" ");
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (stringBuilder.isEmpty()) {
            return new String[0];
        }

        String[] wordResult = stringBuilder.toString().split(" ");
        Arrays.sort(wordResult);

        return wordResult;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
