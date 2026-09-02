package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORD_SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder necessaryWord = new StringBuilder();
            String newWords = reader.readLine();
            while (newWords != null) {
                necessaryWord.append(newWords).append(WORD_SEPARATOR)
                        .append(System.lineSeparator());
                newWords = reader.readLine();
            }
            String[] words = necessaryWord.toString().toLowerCase().split("\\W+");
            StringBuilder resultBuilder = new StringBuilder();
            for (String word : words) {
                if (word.charAt(0) == 'w') {
                    resultBuilder.append(word).append(WORD_SEPARATOR);
                }
            }
            if (resultBuilder.toString().isEmpty()) {
                return new String[0];
            }
            String[] nesessaryWords = resultBuilder.toString().trim().split(WORD_SEPARATOR);
            Arrays.sort(nesessaryWords);
            return nesessaryWords;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        } catch (StringIndexOutOfBoundsException e) {
            return new String[0];
        }
    }
}
