package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> resultWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.toLowerCase().replaceAll("\\p{Punct}", "")
                        .split("\\W+");

                for (String word : lineWords) {
                    if (!word.isEmpty() && word.startsWith("w")) {
                        resultWords.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(resultWords, Collator.getInstance(Locale.ENGLISH));
        return resultWords.toArray(new String[0]);
    }
}
