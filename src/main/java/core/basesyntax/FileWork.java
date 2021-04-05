package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String START_LETTER = "w";
    private static final String[] SIGNS = new String[] {
            ",","!","?","."
    };

    public String[] readFromFile(String fileName) {
        List<String> arrayOfWords = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                for (String word : line.split("\\W+")) {
                    if (word.toLowerCase().startsWith(START_LETTER)) {
                        for (String sign : SIGNS) {
                            if (word.endsWith(sign)) {
                                word = word.substring(0, word.length() - 1);
                            }
                        }
                        arrayOfWords.add(word.toLowerCase());
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        String[] returnedString = arrayOfWords.toArray(new String[0]);
        Arrays.sort(returnedString);
        return returnedString;
    }
}
