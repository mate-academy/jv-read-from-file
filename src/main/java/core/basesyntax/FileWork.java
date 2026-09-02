package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_LETTER_INDEX = 0;
    private static final char FIRST_LETTER = 'w';
    private static final int INITIAL_COUNTER_VALUE = 0;

    public String[] readFromFile(String fileName) {
        String fileInfo;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }

            fileInfo = stringBuilder.toString().toLowerCase().replaceAll("\\p{Punct}", "");
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] words = fileInfo.split("\\s+");

        int wordsCounter = INITIAL_COUNTER_VALUE;

        for (String word : words) {
            if (word != null && !word.isEmpty()
                    && word.toCharArray()[FIRST_LETTER_INDEX] == FIRST_LETTER) {
                wordsCounter++;
            }
        }

        String[] result = new String[wordsCounter];

        wordsCounter = INITIAL_COUNTER_VALUE;

        for (String word : words) {
            if (word != null && !word.isEmpty()
                    && word.toCharArray()[FIRST_LETTER_INDEX] == FIRST_LETTER) {
                result[wordsCounter] = word;
                wordsCounter++;
            }
        }

        Arrays.sort(result);

        return result;
    }
}
