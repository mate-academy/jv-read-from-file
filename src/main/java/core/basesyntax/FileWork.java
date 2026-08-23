package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> newArray = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\W+");
                for (String word : split) {
                    if (word.toLowerCase().startsWith("w")) {
                        newArray.add(word.toLowerCase());
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        newArray.sort(String::compareToIgnoreCase);
        return newArray.toArray(String[]::new);
    }
}
