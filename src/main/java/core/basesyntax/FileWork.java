package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_LETTER = "w";

    private static boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_LETTER);
    }

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> wordsWithSpecifiedLetter = new ArrayList<>();
            String value = reader.readLine();

            while (value != null) {
                String[] words = value.split("\\W+");
                for (String word : words) {
                    if (startWithLetter(word.toLowerCase())) {
                        wordsWithSpecifiedLetter.add(word.toLowerCase());
                    }
                }
                value = reader.readLine();
            }
            Collections.sort(wordsWithSpecifiedLetter);
            return wordsWithSpecifiedLetter.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cant read file.", e);
        }
    }
}
