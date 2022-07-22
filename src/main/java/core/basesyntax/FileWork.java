package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIFIED_REGEX_FOR_SPLIT = "\\W+";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().split(SPECIFIED_REGEX_FOR_SPLIT);
            StringBuilder necessaryWordsBuilder = new StringBuilder();
            for (String word : words) {
                if (startWithLetter(word)) {
                    necessaryWordsBuilder.append(word).append(System.lineSeparator());
                }
            }
            String[] necessaryWords = {};
            if (!necessaryWordsBuilder.toString().isEmpty()) {
                necessaryWords = necessaryWordsBuilder.toString().toLowerCase()
                        .split(SPECIFIED_REGEX_FOR_SPLIT);
                Arrays.sort(necessaryWords);
            }
            return necessaryWords;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }

    public boolean startWithLetter(String word) {
        return word.toLowerCase().startsWith(SPECIFIED_CHARACTER);
    }

}
