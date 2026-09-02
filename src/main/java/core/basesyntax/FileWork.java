package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static final String REGEX = "[^\\da-zA-Z ]";

    public String[] readFromFile(String fileName) {

        try {
            List<String> strings = Files.readAllLines(Path.of(fileName));
            if (strings.size() == 0) {
                return new String[]{};
            }
            List<String> res = new ArrayList<>();
            StringBuilder totalString = new StringBuilder();
            for (String string : strings) {
                totalString.append(" ").append(string);
            }
            String prepearedString = totalString.toString()
                    .replaceAll(REGEX, "")
                    .toLowerCase()
                    .trim();
            String[] words = prepearedString.split(" ");

            for (String word : words) {
                if (word.charAt(0) == 'w') {
                    res.add(word);
                }
            }
            Collections.sort(res);
            return res.toArray(new String[res.size()]);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

}
