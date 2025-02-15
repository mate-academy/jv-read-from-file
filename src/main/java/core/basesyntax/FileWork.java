package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] emptyArray = new String[0];
        File file = new File(fileName);
        List<String> wordsList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\W_]+");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = pattern.split(line.toLowerCase());
                for (String word : words) {
                    if (word.startsWith("w") && !word.isEmpty()) {
                        wordsList.add(word);
                    }
                }
            }
            String[] wordsArray = new String[wordsList.size()];
            wordsList.sort(Comparator.naturalOrder());
            return wordsArray = wordsList.toArray(wordsArray);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Read data from file error", e);
        }
    }
}
