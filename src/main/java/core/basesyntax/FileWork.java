package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';
    private static final char UPPER_SPECIFIED_CHARACTER = 'W';
    private static final String SPACE_SEPARATOR = " ";
    private static final int INDEX = 0;

    public String[] readFromFile(String fileName) {
        String fileRead;
        File readingFile = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(readingFile))) {
            StringBuilder stringBuilder = new StringBuilder();
            String file = bufferedReader.readLine();
            if (file == null || file == "") {
                return new String[INDEX];
            }
            while (file != null) {
                stringBuilder.append(file).append(System.lineSeparator());
                file = bufferedReader.readLine();
            }
            fileRead = stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read to file", e);
        }
        String[] split = fileRead.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word: split) {
            if (word.charAt(INDEX) == SPECIFIED_CHARACTER
                    || word.charAt(INDEX) == UPPER_SPECIFIED_CHARACTER) {
                stringBuilder.append(word.toLowerCase()).append(SPACE_SEPARATOR);
            }
        }
        String wordsStartingLetterW = stringBuilder.toString();
        if (wordsStartingLetterW.length() == 0) {
            return new String[INDEX];
        }
        String[] arrayOfWordsPerLetterW = wordsStartingLetterW.split(SPACE_SEPARATOR);
        Arrays.sort(arrayOfWordsPerLetterW);
        return arrayOfWordsPerLetterW;
    }
}
