package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileWork {
    private static final String SPACE_DELIMITER = " ";
    private static final char LOOKING_CHARACTER = 'w';

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
            String[] wordsOfString = string.toLowerCase()
                                           .split(SPACE_DELIMITER);
            for (String singleWord : wordsOfString) {
                if (singleWord.charAt(0) == LOOKING_CHARACTER) {
                    stringBuilder.append(singleWord)
                                 .append(SPACE_DELIMITER);
                }
            }
        }

        return stringBuilder.toString()
                            .split(SPACE_DELIMITER);
    }
}
