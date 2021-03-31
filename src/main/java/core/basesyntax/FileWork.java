package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split(" ")) {
                    String lowerCaseWord = word.toLowerCase();
                    if (word.length() > 0 && lowerCaseWord.charAt(0) == SPECIFIED_CHARACTER) {
                        String cleanWord = lowerCaseWord
                                .replaceAll("\\s*\\p{Punct}+\\s*$", "");
                        stringBuilder.append(cleanWord);
                        stringBuilder.append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File error ", e);
        }
        if (stringBuilder.length() > 0) {
            String[] resultWords = stringBuilder.toString().split(" ");
            Arrays.sort(resultWords);
            return resultWords;
        }
        return new String[0];
    }
}
