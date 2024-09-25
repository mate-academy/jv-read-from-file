package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPACE = " ";
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> resultList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                String lineWithoutPunctuation = removePunctuation(line).toLowerCase();
                String[] splitLines = lineWithoutPunctuation.split(SPACE);
                for (String splitLine : splitLines) {
                    if (splitLine.startsWith(SPECIFIED_CHARACTER)) {
                        resultList.add(splitLine);
                    }
                }
            }

            if (resultList.isEmpty()) {
                return new String[0];
            } else {
                String[] resultArray = resultList.toArray(resultList.toArray(new String[0]));
                Arrays.sort(resultArray);
                return resultArray;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String removePunctuation(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
