package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    private String[] getWordsStartingWithW(String words) {
        String[] filteredWords = words.split("\\W+");
        ArrayList<String> wordsList = new ArrayList<>();

        for (String filteredWord : filteredWords) {
            if (filteredWord.isEmpty()) {
                continue;
            }

            String firstLetter = String.valueOf(filteredWord.charAt(0)).toLowerCase();

            if (firstLetter.equals("w")) {
                wordsList.add(filteredWord);
            }
        }

        wordsList.sort(String::compareToIgnoreCase);

        return wordsList.toArray(new String[0]);
    }

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            ArrayList<String> wordsList = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                wordsList.add(line.toLowerCase());
            }

            return getWordsStartingWithW(wordsList.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
