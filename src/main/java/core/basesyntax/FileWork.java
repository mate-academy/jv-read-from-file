package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File inputFile = new File(fileName);
        String line;
        StringBuilder matchedWords = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            line = bufferedReader.readLine();
            while (line != null) {
                for (String word : line.split("\\W+")) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        matchedWords.append(word.toLowerCase()).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Cant read a file", e);
        }

        String[] matchedWordsArray = matchedWords.toString().trim().split("\\s+");
        Arrays.sort(matchedWordsArray);

        return !matchedWords.isEmpty() ? matchedWordsArray : new String[]{};
    }
}
