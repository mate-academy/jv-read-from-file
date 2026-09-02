package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    public String[] readFromFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] split = currentLine.split("\\W+");
                for (String word : split) {
                    word = word.toLowerCase();
                    if (startWithLetter(word)) {
                        words.add(word);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = words.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }
}
