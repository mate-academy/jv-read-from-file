package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileWork {

    public static final String SPECIAL_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String textFromFile = readAllFromFile(fileName);
        if (textFromFile.length() == 0) {
            return new String[0];
        }
        String[] words = textFromFile.split("\\W+");
        String[] wordsStartingWithW = new String[words.length];
        int index = 0;
        for (String word : words) {
            if (word.toLowerCase().startsWith(SPECIAL_CHARACTER)) {
                wordsStartingWithW[index] = word.toLowerCase();
                index++;
            }
        }
        wordsStartingWithW = Arrays.copyOf(wordsStartingWithW, index);
        wordsStartingWithW = Stream.of(wordsStartingWithW).sorted().toArray(String[]::new);
        return wordsStartingWithW;
    }

    private String readAllFromFile(String fileName) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str).append("\n");
            }
        } catch (FileNotFoundException f) {
            throw new RuntimeException(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
