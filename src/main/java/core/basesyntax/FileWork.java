package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringReader = new StringBuilder();
        File file = new File(fileName);
        try {
            stringReader.append(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        int counter = 0;
        String[] splitText = stringReader.toString().split("\\W+");
        for (String s : splitText) {
            if (isWordStartsWithLetter(s)) {
                counter++;
            }
        }
        String[] result = new String[counter];
        int index = 0;
        for (String s : splitText) {
            if (isWordStartsWithLetter(s)) {
                result[index] = s.toLowerCase();
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean isWordStartsWithLetter(String word) {
        return word.toLowerCase().startsWith(SPECIAL_LETTER);
    }
}
