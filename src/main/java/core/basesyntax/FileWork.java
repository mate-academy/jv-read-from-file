package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileWork {
    private static final String TARGET_CHARACTER = "w";
    private static final String REGEX_CONST = "\\W";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> wordsArray = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stringArray = line.split(REGEX_CONST);
                for (String word : stringArray) {
                    if (word.toLowerCase().startsWith(TARGET_CHARACTER)) {
                        wordsArray.add(word.toLowerCase(Locale.ROOT));
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        String[] finalArray = wordsArray.toArray(new String[wordsArray.size()]);
        Arrays.sort(finalArray);
        return finalArray;
    }
}
