package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileWork {
    private static final int NUMBER = 0;

    public String[] readFromFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return new String[NUMBER];
        }
        List<String> necessaryWords = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String readData;

            while ((readData = bufferedReader.readLine()) != null) {
                String[] splitString = readData.split("\\W+");
                for (String word : splitString) {
                    if (!word.isEmpty() && (word.charAt(NUMBER) == 'w'
                            || word.charAt(NUMBER) == 'W')) {
                        necessaryWords.add(word.toLowerCase(Locale.ROOT));
                    }
                }
            }
            Collections.sort(necessaryWords);
        } catch (IOException e) {
            throw new RuntimeException("File can't find!!");
        }

        return necessaryWords.toArray(new String[NUMBER]);
    }
}

