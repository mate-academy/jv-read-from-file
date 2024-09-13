package core.basesyntax;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileWork {
    String fileForRead = "fileForRead.txt";
    String lowerString = "";

    public String[] readFromFile(String fileForRead) {
        File myFile = new File("fileForRead.txt");
        List<String> wordList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] split = value.split("\\W+");
                for(String word : split) {
                    wordList.add(word.toLowerCase());
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return wordList.toArray(new String[0]);
    }
}

