package core.basesyntax;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        Reader reader = new Reader();
        ArrayList<String> result = new ArrayList<>();
        List<String> strings = reader.readFileWithData(file.toPath());

        for (String string : strings) {
            for (String word : string.replaceAll("[.,?!]", "").split("\\s+")) {
                if (word.toLowerCase().startsWith("w")) {
                    result.add(word.toLowerCase());
                }
            }
        }

        Collections.sort(result);
        return result.toArray(String[]::new);
    }
}
