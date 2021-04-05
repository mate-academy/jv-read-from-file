package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        List<String> strings;

        try {
            strings = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string
                    .replaceAll("\\W", " ")).append(" ");

        }

        String resultString = stringBuilder.toString().strip().toLowerCase();
        String[] tempArray = resultString.split(" ");
        int count = 0;
        for (String value : tempArray) {
            if (startWithLetter(value)) {
                count++;
            }
        }

        String[] resultArray = new String[count];
        count = 0;
        for (String string : tempArray) {
            if (startWithLetter(string)) {
                resultArray[count] = string.toLowerCase();
                count++;
            }
        }
        Arrays.sort(resultArray);

        return resultArray;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
