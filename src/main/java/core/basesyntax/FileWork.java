package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final String SPLITTER = " ";
    private static final String W_LOWER_CHARACTER = "w";
    private static final String W_UPPER_CHARACTER = "W";
    private static final String[] symbolsToDelete = {"'", "!", "?", ".", ",", ";"};

    public String[] readFromFile(String fileName) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(SPLITTER);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String[] splittedWords = stringBuilder.toString().split(SPLITTER);
        ArrayList<String> wordsList = new ArrayList<>();

        for (String word : splittedWords) {
            if (word.startsWith(W_LOWER_CHARACTER) || word.startsWith(W_UPPER_CHARACTER)) {
                word = word.toLowerCase().trim();
                wordsList.add(word);
            }
        }

        for (String symbol : symbolsToDelete) {
            for (int i = 0; i < wordsList.size(); i++) {
                if (wordsList.get(i).contains(symbol)) {
                    wordsList.set(i, wordsList.get(i).replace(symbol, ""));
                }
            }
        }

        Collections.sort(wordsList);
        String[] result = new String[wordsList.size()];
        result = wordsList.toArray(result);
        return result;
    }
}
