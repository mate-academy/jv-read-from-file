package core.basesyntax;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> wordsStartingWithW = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty() && word.startsWith("w")) {
                        wordsStartingWithW.add(word);
                    }
                }
            }

            Collections.sort(wordsStartingWithW);
            return wordsStartingWithW.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }
    }
}





        /*

        String fileUpper = fileName.toUpperCase();
        char c1;
        char c2;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null){
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        String[] words = fileName.split("[\\s\\p{Punct}]+");

        */

