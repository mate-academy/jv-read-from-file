package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.TreeSet;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        TreeSet<String> set;
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String text = String.join(" ", strings);
            String[] tokens = text.split("[\\s\\p{Punct}]+");
            set = new TreeSet<>();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    token = token.toLowerCase();
                    if (token.charAt(0) == 'w') {
                        set.add(token);
                    }
                }
            }
            return set.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file " + e);
        }

    }

}
