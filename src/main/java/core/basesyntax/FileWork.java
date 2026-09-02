package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {

        //write your code here
        File file = new File(fileName);
        try {
            List<String> wordsWithStartW = new ArrayList<>();
            List<String> strings = Files.readAllLines(file.toPath());
            for (String string : strings) {
                String[] words = string.toLowerCase().split("[ .,:;!?]");
                for (String word : words) {
                    if (word.startsWith("w")) {
                        wordsWithStartW.add(word);
                    }
                }
                wordsWithStartW.sort(Comparator.naturalOrder());
            }
            return wordsWithStartW.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}


