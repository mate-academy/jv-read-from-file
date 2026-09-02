package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        List<String> resultData = new ArrayList<>();
        File file = new File(fileName);
        try {
            String [] strings = Files.readAllLines(file.toPath()).toString().split("\\W+");
            for (int i = 1; i < strings.length; i++) {
                if (strings[i].toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                    resultData.add(strings[i].toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        Collections.sort(resultData);
        return resultData.toArray(new String[0]);
    }
}
