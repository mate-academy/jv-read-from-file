package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char CONDITIONAL_LATTER = 'w';

    public String[] readFromFile(String fileName) {
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String value = reader.readLine();
            while (value != null) {

                for (String word : value.toLowerCase().split("\\W+")) {
                    if (word.startsWith(String.valueOf(CONDITIONAL_LATTER))) {
                        filteredWords.add(word.replaceAll("\\p{P}", ""));
                    }
                }
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(filteredWords);

        return filteredWords.toArray(new String[0]);
    }
}
