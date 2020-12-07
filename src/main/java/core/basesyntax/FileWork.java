package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> listOfWords;
        try {
            listOfWords = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
        return wordsFromListLowerCase(listOfWords);
    }

    private String[] wordsFromListLowerCase(List<String> listOfWords) {
        StringBuilder textBuilder = new StringBuilder();

        for (String word : listOfWords) {
            textBuilder.append(word.toLowerCase()).append(System.lineSeparator());
            if (textBuilder.length() == 0) {
                return new String[0];
            }
        }

        String[] wordsArray = textBuilder.toString().toLowerCase().split("[^\\w]");
        textBuilder = new StringBuilder();

        for (String word : wordsArray) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                textBuilder.append(word).append(" ");
            }
        }
        if (textBuilder.toString().length() == 0) {
            return new String[0];
        }
        wordsArray = textBuilder.toString().split(" ");
        Arrays.sort(wordsArray);
        return wordsArray.length == 0 ? new String[0] : wordsArray;
    }
}
