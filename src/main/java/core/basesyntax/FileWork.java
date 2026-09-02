package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] words = data.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                        wordList.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file" + e);
        }
        String[] finalList = wordList.toArray(new String[0]);
        Arrays.sort(finalList);
        return finalList;
    }
}
