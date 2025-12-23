package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String text;

            while ((text = bufferedReader.readLine()) != null) {
                String[] tokens = text.split("\\s+");

                for (String token : tokens) {
                    String word = token.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result.sort(String::compareTo);

        return result.toArray(new String[0]);
    }
}
