package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            String text = String.join(" ", strings);
            String[] tokens = text.split("[\\s\\p{Punct}]+");
            ArrayList<String> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    token = token.toLowerCase();
                    if (token.charAt(0) == 'w') {
                        list.add(token);
                    }
                }
            }
            Collections.sort(list);
            return list.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read a file " + e);
        }
    }
}
