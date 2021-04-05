package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIFIED_REGEX = "[.,;?!]";
    private static final String WHITE_SPACE = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(WHITE_SPACE);
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        stringBuilder.append(word).append(WHITE_SPACE);
                        result = stringBuilder.toString().toLowerCase()
                                .replaceAll(SPECIFIED_REGEX, "");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + fileName, e);
        }
        if (result.length() > 0) {
            String[] resultArray = result.split(WHITE_SPACE);
            Arrays.sort(resultArray);
            return resultArray;
        } else {
            return new String[0];
        }
    }
}
