package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char FIRST_LETTER = 'w';
    private static final String REGEX = "\\W+";
    private static final int ZERO_POSITION = 0;

    public String[] readFromFile(String fileName) {

        try {
            File file = new File(fileName);
            String[] stringWords = Files.readAllLines(file.toPath())
                    .toArray(new String[ZERO_POSITION]);
            String[] result = getListWords(stringWords).toArray(new String[ZERO_POSITION]);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data with file", e);
        }
    }

    private List<String> getListWords(String[] stringWords) {
        List<String> resultList = new ArrayList<>();
        for (String stringWord : stringWords) {
            String[] temporaryArray = stringWord.split(REGEX);
            for (int i = 0; i < temporaryArray.length; i++) {
                if (temporaryArray[i].toLowerCase().charAt(ZERO_POSITION) == FIRST_LETTER) {
                    resultList.add(temporaryArray[i].toLowerCase());
                }
            }
        }
        return resultList;
    }
}
