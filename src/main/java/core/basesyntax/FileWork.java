package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);

        try {
            String fileContents = Files.readString(file.toPath());

            List<String> words = new LinkedList<>();

            for (String str: fileContents.toLowerCase().split("\\W+")) {
                str = str.toLowerCase();
                if (str.startsWith("w")) {
                    words.add(str);
                }
            }
            Collections.sort(words);
            return words.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file " + fileName);
        }
    }
}
