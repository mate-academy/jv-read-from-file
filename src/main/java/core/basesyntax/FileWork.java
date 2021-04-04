package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public static final String CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] finalArray;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String result = stringBuilder.toString();
            String lowerCaseWords = result.toLowerCase();
            String[] strings = lowerCaseWords.split("\\W");
            Arrays.sort(strings);
            ArrayList<String> wordsArray = new ArrayList<>();
            for (String word : strings) {
                if (word.toLowerCase()
                        .startsWith(CHARACTER)) {
                    wordsArray.add(word);
                }
            }
            finalArray = wordsArray.toArray(new String[wordsArray.size()]);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        return finalArray;
    }
}
