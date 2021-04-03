package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final int DESIRED_POSITION = 0;
    private static final char LOOKING_CHARACTER = 'w';
    private static final String NOT_LETTER_DELIMITER = "[^a-zA-Z]";
    private static final String SPACE_DELIMITER = " ";
    private static final String EMPTY_DELIMITER = "";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        List<String> stringsFromFile;
        try {
            stringsFromFile = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file", e);
        }

        for (String string : stringsFromFile) {
            String[] wordsOfString = string.toLowerCase().split(SPACE_DELIMITER);
            for (String singleWord : wordsOfString) {
                if (singleWord.charAt(DESIRED_POSITION) == LOOKING_CHARACTER) {
                    stringBuilder.append(singleWord.replaceAll(NOT_LETTER_DELIMITER,
                            EMPTY_DELIMITER))
                                 .append(SPACE_DELIMITER);
                }
            }
        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        }

        String[] resultArray = stringBuilder.toString().split(SPACE_DELIMITER);
        Arrays.sort(resultArray);

        return resultArray;
    }
}
