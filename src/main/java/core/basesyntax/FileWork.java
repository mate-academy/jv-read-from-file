package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsList = new ArrayList<>();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\W+");
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (word.charAt(0) == 'w') {
                    wordsList.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to find file", e);
        }

        String[] wordsArray = new String[wordsList.size()];
        wordsList.toArray(wordsArray);
        Arrays.sort(wordsArray);
        return wordsArray;
    }
}
