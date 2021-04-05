package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String readString = bufferedReader.readLine();
            String[] tempArray;

            List<String> wordList = new ArrayList<>();
            while (readString != null) {
                tempArray = readString.split(" ");
                for (String word : tempArray) {
                    word = word.toLowerCase();
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        wordList.add(word.replaceAll("[^a-z]", ""));
                    }
                }
                readString = bufferedReader.readLine();
            }
            Collections.sort(wordList);
            String[] resultArray = new String[wordList.size()];
            int i = 0;
            for (String word : wordList) {
                resultArray[i] = word;
                i++;
            }
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("File does not exist.");
        }
    }
}
