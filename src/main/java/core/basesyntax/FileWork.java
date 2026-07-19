package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        if (fileName == null) {
            throw new RuntimeException("Resource not found: fileName");
        }
        List<String> results = new ArrayList<>();
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            for (String string : strings) {
                String[] words = string.split("\\W+");

                for (String word : words) {
                    word = word.toLowerCase();
                    if ((!word.isEmpty()) && (word.charAt(0) == 'w')) {
                        results.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String[] listArrayResult = results.toArray(new String[0]);
        Arrays.sort(listArrayResult);
        return listArrayResult;
    }
}
