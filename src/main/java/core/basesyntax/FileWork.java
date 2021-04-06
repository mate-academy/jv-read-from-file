package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String firstLetter = "w";
    private static final String regex = "[.!?]";

    public String[] readFromFile(String file01) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file01))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File cannot be read", e);
        }
        String[] words = stringBuilder.toString().toLowerCase().split(" ");
        StringBuilder wordsToArray = new StringBuilder();
        for (String findCharacter : words) {
            String temp = findCharacter.replaceAll(regex, "");
            if (temp.startsWith(firstLetter)) {
                wordsToArray.append(temp).append(" ");
            }
        }

        String[] wordsWithW = wordsToArray.toString().split(" ");
        Arrays.sort(wordsWithW);

        return wordsWithW;
    }
}
