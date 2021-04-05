package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String START_LETTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> arrayOfWords = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (word.startsWith(START_LETTER)) {
                        arrayOfWords.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        Collections.sort(arrayOfWords);
        return arrayOfWords.toArray(new String[0]);
    }
}
