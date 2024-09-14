package core.basesyntax;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileWork {
    public String[] readFromFile(String file) {
        File myFile = new File(file);
        List<String> wordList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] split = value.split("\\W+");
                for(String word : split) {
                    if (!word.isEmpty() && word.substring(0,1).equals("w")
                            || word.substring(0,1).equals("W") || split.length == 0) {
                        wordList.add(word.toLowerCase());
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return wordList.toArray(new String[0]);
    }
}

