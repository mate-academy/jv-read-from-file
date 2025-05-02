package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> resultList = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty() && word.toLowerCase().startsWith("w")) {
                        resultList.add(word.toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the file", e);
        }

        return resultList.stream().sorted().toArray(String[]::new);
    }
}
