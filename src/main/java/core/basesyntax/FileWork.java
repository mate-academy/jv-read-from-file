package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String FIRST_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> words;
        StringBuilder builder = new StringBuilder();
        try {
            words = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Reading failed", e);
        }
        List<String> listAnswer = new ArrayList<>();
        for (String word : words) {
            String[] wordsOnly = word.toLowerCase().split("\\W+");
            for (int i = 0; i < wordsOnly.length; i++) {
                if (wordsOnly[i].startsWith(FIRST_LETTER)) {
                    listAnswer.add(wordsOnly[i]);
                }
            }
            if (listAnswer == null) {
                return new String[0];
            }
        }
        String [] strAnswer = listAnswer.toArray(new String[0]);
        Arrays.sort(strAnswer);
        //write your code here
        return strAnswer;
    }
}
