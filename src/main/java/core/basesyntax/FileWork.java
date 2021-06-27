package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String REPLACING_MATCH = "\\W";

    public String[] readFromFile(String fileName) {
        String wholeText = copyTextFromFile(fileName);
        return findAllWordsWithW(wholeText);
    }

    private String copyTextFromFile(String fileName) {
        StringBuilder wholeText = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineOfText = bufferedReader.readLine();
            while (lineOfText != null) {
                wholeText.append(lineOfText).append(" ");
                lineOfText = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File couldn't be found", e);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read a file", e);
        }
        return wholeText.toString();
    }

    private String[] findAllWordsWithW(String wholeText) {
        if (wholeText.length() != 0) {
            String[] wholeTextArray = wholeText.toLowerCase().split(REPLACING_MATCH);
            List<String> wordsWithW = new ArrayList<>();
            for (String word : wholeTextArray) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    wordsWithW.add(word);
                }
            }
            Collections.sort(wordsWithW);
            return wordsWithW.toArray(new String[0]);
        }
        return new String[0];
    }
}
