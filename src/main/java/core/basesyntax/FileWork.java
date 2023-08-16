package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] tokens = temp.toLowerCase().split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})");
                for (String token : tokens) {
                    if (token.startsWith("w")) {
                        words.add(token);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(words);

        return words.toArray(new String[0]);
    }
}
