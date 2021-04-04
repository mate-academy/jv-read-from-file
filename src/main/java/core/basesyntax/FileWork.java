package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
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

    public String[] readFromFile(String firstFileName) {
        File file = new File(firstFileName);
        List<String> arrayOfWords = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                for (String word : value.split(" ")) {
                    if (word.toLowerCase().startsWith(START_LETTER)) {
                        for (String sign : SIGNS) {
                            if (word.endsWith(sign)) {
                                word = word.substring(0, word.length() - 1);
                            }
                        }
                        arrayOfWords.add(word.toLowerCase());
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        if (arrayOfWords.size() == 0) {
            return new String[0];
        }
        String[] returnedString = arrayOfWords.toArray(new String[0]);
        Arrays.sort(returnedString);
        return returnedString;
    }
}
