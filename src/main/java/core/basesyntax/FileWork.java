package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public static final String SPECIFIED_LETTER = "w";
    public static final String SPECIFIED_REGEX = "\\W+";

    public String[] readFromFile(String fileName) {
        ArrayList<String> dynamicStringArray = new ArrayList<>();

        try {
            String content = Files.readString(Paths.get(fileName));
            String[] wordArr = content.split(SPECIFIED_REGEX);

            for (String word:wordArr) {
                if (word.toLowerCase().startsWith(SPECIFIED_LETTER)) {
                    dynamicStringArray.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(dynamicStringArray);
        return dynamicStringArray.toArray(new String[0]);
    }
}
