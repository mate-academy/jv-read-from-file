package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String LETTER_REQUIRED = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder validWordsLineBuilder = new StringBuilder();
            String value;
            while ((value = reader.readLine()) != null) {
                String[] initialWords = value.split("\\W+");
                for (String initialWord : initialWords) {
                    if (initialWord.toLowerCase().startsWith(LETTER_REQUIRED)) {
                        validWordsLineBuilder.append(initialWord.toLowerCase())
                                .append(" ");
                    }
                }
            }
            if (validWordsLineBuilder.length() == 0) {
                return new String[0];
            }
            String[] words = validWordsLineBuilder.toString().trim().split(" ");
            Arrays.sort(words);
            return words;
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file: " + fileName, e);
        }
    }
}
