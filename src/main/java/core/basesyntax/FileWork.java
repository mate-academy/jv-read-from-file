package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String i : lines) {
                String[] words = i.split("[\\s\\p{Punct}]+");
                for (String word: words) {
                    if (!word.isEmpty() && Character.toLowerCase(word.charAt(0)) == 'w') {
                        list.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}
