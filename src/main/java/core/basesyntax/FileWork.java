package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {

    public String[] readFromFile(String fileName) {

        List<String> sortWordss = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String[] words = str.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        sortWordss.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        sortWordss.sort(String::compareToIgnoreCase);
        return sortWordss.toArray(new String[0]);
    }
}

