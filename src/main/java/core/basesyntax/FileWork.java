package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String WORD_DELIMITER = "\\W+";

    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.split(WORD_DELIMITER);
                addFilteredWordsToList(list, words);

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File '" + fileName + "' not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file '" + fileName + "'.", e);
        }

        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    private void addFilteredWordsToList(List<String> filteredWords, String[] words) {
        for (String word : words) {
            char ch = word.charAt(0);

            if (ch == 'w' || ch == 'W') {
                filteredWords.add(word.toLowerCase());
            }
        }
    }
}
