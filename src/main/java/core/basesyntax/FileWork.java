package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String data;
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName))).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        return detectWords(data.split("\\W+"));
    }

    public String[] detectWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                list.add(word);
            }
        }
        Collections.sort(list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
