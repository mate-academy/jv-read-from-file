package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        try {
            List<String> preResult = new ArrayList<String>();
            String file = Files.readString(Paths.get(fileName)).toLowerCase();
            if (file.length() > 0) {
                for (String word : file.split("[^A-Za-zА-Яа-я]+")) {
                    if (word.substring(0, 1).equals(LETTER)) {
                        preResult.add(word);
                    }
                }
            }
            Collections.sort(preResult);
            return preResult.toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
