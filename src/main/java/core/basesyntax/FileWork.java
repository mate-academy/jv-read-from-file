package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String CAN_T_OPEN_FILE_MESSAGE = "Can't open file";
    private static final String CAN_T_READ_FILE_MESSAGE = "Can't read file";
    private static final String REGEX_ONLY_WORDS = "\\W+";
    private static final String W_START_WORD_LOWER_LETTER = "w";
    private static final String SPACE_WORDS_DELIMITER = " ";
    private static final String[] EMPTY_ARRAY = {};

    public String[] readFromFile(String fileName) {
        String[] result = null;
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((Character.toLowerCase((char) value)));
                value = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(CAN_T_OPEN_FILE_MESSAGE, e);
        } catch (IOException e) {
            throw new RuntimeException(CAN_T_READ_FILE_MESSAGE, e);
        }

        result = stringBuilder.toString().split(REGEX_ONLY_WORDS);
        stringBuilder.delete(0, stringBuilder.length());
        for (String word : result) {
            if (word.startsWith(W_START_WORD_LOWER_LETTER)) {
                stringBuilder.append(word).append(SPACE_WORDS_DELIMITER);
            }
        }

        if (stringBuilder.length() == 0) {
            return EMPTY_ARRAY;
        }

        result = stringBuilder.toString().trim().split(SPACE_WORDS_DELIMITER);

        Arrays.sort(result);

        return result;
    }
}
