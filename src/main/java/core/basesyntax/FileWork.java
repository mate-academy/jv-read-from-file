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
            String text = Files.readString(Paths.get(fileName)).toLowerCase();
            if (text.length() > 0) {
                for (String word : text.split("\\W+")) {
                    if (word.startsWith(LETTER)) {
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
