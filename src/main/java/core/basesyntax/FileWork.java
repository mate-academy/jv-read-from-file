package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        String[] neededWords = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String lineInFile = bufferedReader.readLine();
            while (lineInFile != null) {
                stringBuilder.append(lineInFile).append(System.lineSeparator());
                lineInFile = bufferedReader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can not read file");
        }
        String[] wordsFromFile = stringBuilder.toString().split("\\W+");
        for (int i = 0; i < wordsFromFile.length; i++) {
            wordsFromFile[i] = wordsFromFile[i].toLowerCase();
            if (startWithLetter(wordsFromFile[i])) {
                stringBuilder1.append(wordsFromFile[i]).append(" ");
            }
        }
        if (stringBuilder1.toString().equals("")) {
            return neededWords;
        }
        neededWords = stringBuilder1.toString().split(" ");
        Arrays.sort(neededWords);
        return neededWords;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
