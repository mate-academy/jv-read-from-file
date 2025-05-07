package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPLITTER_REGEX = "[\\s|\\W]";
    private static final Pattern VALID_STARTING_WORD = Pattern.compile("^[wW][\\w]+",
            Pattern.CASE_INSENSITIVE);
    private static final int ARRAY_SIZE_MULTIPLIER = 2;

    public String[] readFromFile(String fileName) {
        String[] resultArray = new String[10];
        int counter = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] wordsArray = line.split(SPLITTER_REGEX);
                for (String word : wordsArray) {
                    if (isStartWithLetterW(word)) {
                        if (resultArray.length == counter) {
                            resultArray = increaseArraySize(resultArray);
                        }
                        resultArray[counter++] = word.toLowerCase();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        resultArray = decreaseArraySize(resultArray);
        Arrays.sort(resultArray);
        return resultArray;
    }

    private boolean isStartWithLetterW(String word) {
        return VALID_STARTING_WORD.matcher(word).matches();
    }

    private String[] increaseArraySize(String[] oldArray) {
        int size = oldArray.length * ARRAY_SIZE_MULTIPLIER;
        return Arrays.copyOf(oldArray, size);
    }

    private String[] decreaseArraySize(String[] oldArray) {
        int counter = 0;
        for (String word : oldArray) {
            if (word != null) {
                counter++;
            }
        }
        return Arrays.copyOf(oldArray, counter);
    }
}
