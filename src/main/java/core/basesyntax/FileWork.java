package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        Pattern nonAlphabeticPattern = Pattern.compile("[^a-zA-Z]");
        List<String> wordsStartingWithW = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    word = nonAlphabeticPattern.matcher(word).replaceAll("");
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        wordsStartingWithW.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(wordsStartingWithW);

        return wordsStartingWithW.toArray(new String[0]);
    }
}
