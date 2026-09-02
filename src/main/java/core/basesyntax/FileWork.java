package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIAL_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append((value).toLowerCase()).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String listOfAllWords = stringBuilder.toString();
        return getArrayOfWords(listOfAllWords);
    }

    private String[] getArrayOfWords(String words) {
        String[] splitArray = words.split("\\W+");
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (String word : splitArray) {
            if (word.startsWith(SPECIAL_CHARACTER)) {
                builder.append(word).append(" ");
                counter++;
            }
        }
        if (counter == 0) {
            return new String[]{};
        }
        String[] strings = builder.toString().split(" ");
        Arrays.sort(strings);
        return strings;
    }
}
