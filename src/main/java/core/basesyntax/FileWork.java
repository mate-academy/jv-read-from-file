package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String content;
        ArrayList<String> list = new ArrayList<String>();
        try {
            String[] words = Files.readString(Paths.get(fileName)).toLowerCase()
                    .replaceAll("[\\p{Punct}\r\n]", " ").split(" ");
            Arrays.sort(words);
            for (String all : words) {
                if (all.startsWith("w")) {
                    list.add(all);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Find some Exception", e);
        }
        return list.toArray(new String[list.size()]);
    }
}
